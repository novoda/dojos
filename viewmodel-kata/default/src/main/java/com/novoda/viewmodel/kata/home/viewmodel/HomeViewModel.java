package com.novoda.viewmodel.kata.home.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.novoda.viewmodel.kata.data.Note;
import com.novoda.viewmodel.kata.home.HomeService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends ViewModel {

    private final HomeService homeService;

    private final MutableLiveData<List<Note>> liveNotes = new MutableLiveData<>();
    private final CompositeDisposable disposables = new CompositeDisposable();

    public HomeViewModel(HomeService homeService) {
        this.homeService = homeService;
    }

    public LiveData<List<Note>> getAllNotes() {
        loadData();
        return liveNotes;
    }

    public void insertNewNote(String newNoteText) {
        Disposable disposable = homeService.insert(newNoteText)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onItemSaved);

        disposables.add(disposable);
    }

    private final Action onItemSaved = new Action() {
        @Override
        public void run() {
            loadData();
        }
    };

    private void loadData() {
        Disposable disposable = homeService.retrieve()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onDataLoaded);

        disposables.add(disposable);
    }

    private final Consumer<List<Note>> onDataLoaded = new Consumer<List<Note>>() {
        @Override
        public void accept(List<Note> notes) {
            liveNotes.postValue(notes);
        }
    };

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.dispose();
    }
}
