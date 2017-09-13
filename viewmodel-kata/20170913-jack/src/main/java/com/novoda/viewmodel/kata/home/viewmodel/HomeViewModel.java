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

    public HomeViewModel(HomeService homeService) {
        this.homeService = homeService;
    }

    public LiveData<List<Note>> getNotes() {
        if (notes == null) {
            notes = new MutableLiveData<>();
            loadNotes();
        }
        return notes;
    }

    private void loadNotes() {
        homeService.retrieve()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Note>>() {
                    @Override
                    public void accept(List<Note> notes) throws Exception {
                        HomeViewModel.this.notes.setValue(notes);
                    }
                });
    }

    public void insertNote(String noteText) {
        homeService.insert(noteText)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                        loadNotes();
                    }
                });
    }

}
