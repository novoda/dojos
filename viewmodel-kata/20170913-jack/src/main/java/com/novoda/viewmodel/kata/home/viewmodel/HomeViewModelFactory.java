package com.novoda.viewmodel.kata.home.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;

import com.novoda.viewmodel.kata.db.AppDatabaseCreator;
import com.novoda.viewmodel.kata.db.dao.NoteDaoRepository;
import com.novoda.viewmodel.kata.home.HomeService;

public class HomeViewModelFactory implements ViewModelProvider.Factory{

    private final Context applicationContext;

    public HomeViewModelFactory(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            return createHomeViewModel();
        } else {
            throw new IllegalArgumentException("unknown model class " + modelClass);
        }

    }

    @SuppressWarnings("unchecked")
    private <T extends ViewModel> T createHomeViewModel() {
        NoteDaoRepository noteDaoRepository = AppDatabaseCreator.create(applicationContext).noteDao();
        HomeService homeService = new HomeService(noteDaoRepository);
        return (T) new HomeViewModel(homeService);

    }
}
