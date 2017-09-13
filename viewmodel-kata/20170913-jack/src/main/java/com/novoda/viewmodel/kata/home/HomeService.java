package com.novoda.viewmodel.kata.home;

import com.novoda.viewmodel.kata.data.Note;
import com.novoda.viewmodel.kata.db.dao.NoteDaoRepository;
import com.novoda.viewmodel.kata.db.entity.NoteEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;

public class HomeService {

    private final NoteDaoRepository repository;

    public HomeService(NoteDaoRepository repository) {
        this.repository = repository;
    }

    public Observable<List<Note>> retrieve() {
        return Observable.fromCallable(getAll())
                .map(toNote());
    }

    private Callable<List<NoteEntity>> getAll() {
        return new Callable<List<NoteEntity>>() {
            @Override
            public List<NoteEntity> call() {
                return repository.getAll();
            }
        };
    }

    private Function<List<NoteEntity>, List<Note>> toNote() {
        return new Function<List<NoteEntity>, List<Note>>() {
            @Override
            public List<Note> apply(List<NoteEntity> noteEntities) {
                List<Note> notes = new ArrayList<>();
                for (NoteEntity noteEntity : noteEntities) {
                    notes.add(new Note(noteEntity.getText()));
                }
                return notes;
            }
        };
    }

    public Completable insert(final String noteText) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                repository.insert(new NoteEntity(noteText));
            }
        });
    }
}
