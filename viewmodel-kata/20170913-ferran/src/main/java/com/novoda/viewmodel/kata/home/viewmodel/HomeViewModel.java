package com.novoda.viewmodel.kata.home.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.novoda.viewmodel.kata.data.Note;
import com.novoda.viewmodel.kata.home.HomeService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends ViewModel {

    private final HomeService homeService;

    private MutableLiveData<List<Note>> notes;

    HomeViewModel(HomeService homeService) {
        this.homeService = homeService;
    }

    public LiveData<List<Note>> getAllNotes() {
        if (notes == null) {
            notes = new MutableLiveData<>();
            loadAllNotes();
        }

        return notes;
    }

    private void loadAllNotes() {
        homeService.retrieve()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onDataLoaded);
    }

    private final Consumer<List<Note>> onDataLoaded = new Consumer<List<Note>>() {
        @Override
        public void accept(List<Note> newNotes) {
            notes.setValue(newNotes);
        }
    };

    public void insetNewNote(String newNoteText) {
        homeService.insert(newNoteText)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onItemSaved);
    }

    private final Action onItemSaved = new Action() {
        @Override
        public void run() {
            loadAllNotes();
        }
    };
}
