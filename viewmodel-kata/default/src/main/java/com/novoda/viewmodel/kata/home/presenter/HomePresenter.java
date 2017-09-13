package com.novoda.viewmodel.kata.home.presenter;

import com.novoda.viewmodel.kata.data.Note;
import com.novoda.viewmodel.kata.home.HomeService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter {

    private final HomeDisplayer homeDisplayer;
    private final HomeService homeService;

    private final CompositeDisposable disposables = new CompositeDisposable();

    public HomePresenter(HomeDisplayer homeDisplayer, HomeService homeService) {
        this.homeService = homeService;
        this.homeDisplayer = homeDisplayer;
    }

    public void startPresenting() {
        homeDisplayer.attach(actionListener);
        loadData();
    }

    private final HomeActionListener actionListener = new HomeActionListener() {
        @Override
        public void onNewNoteAdded(String noteText) {
            saveItem(noteText);
        }
    };

    private void saveItem(String title) {
        Disposable disposable = homeService.insert(title)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onItemSaved);

        disposables.add(disposable);
    }

    private final Action onItemSaved = new Action() {
        @Override
        public void run() throws Exception {
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
        public void accept(List<Note> todos) throws Exception {
            homeDisplayer.display(todos);
        }
    };

    public void stopPresenting() {
        disposables.dispose();
    }
}

