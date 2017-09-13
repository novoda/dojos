package com.novoda.viewmodel.kata.home.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;

import com.novoda.viewmodel.kata.db.AppDatabaseCreator;
import com.novoda.viewmodel.kata.db.dao.NoteDaoRepository;
import com.novoda.viewmodel.kata.home.HomeService;

public class HomeViewModelFactory implements ViewModelProvider.Factory {

    private final HomeService homeService;

    public static HomeViewModelFactory newInstance(Context context) {
        NoteDaoRepository noteDaoRepository = AppDatabaseCreator.create(context).noteDao();
        HomeService homeService = new HomeService(noteDaoRepository);
        return new HomeViewModelFactory(homeService);
    }
    public HomeViewModelFactory(HomeService homeService) {
        this.homeService = homeService;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            return (T) new HomeViewModel(homeService);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
