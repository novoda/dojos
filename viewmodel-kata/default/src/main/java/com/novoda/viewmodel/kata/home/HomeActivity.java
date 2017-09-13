package com.novoda.viewmodel.kata.home;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.widget.TextView;

import com.novoda.viewmodel.kata.R;
import com.novoda.viewmodel.kata.data.Note;
import com.novoda.viewmodel.kata.db.AppDatabaseCreator;
import com.novoda.viewmodel.kata.db.dao.NoteDaoRepository;
import com.novoda.viewmodel.kata.home.viewmodel.HomeViewModel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class HomeActivity extends LifecycleActivity {

    private TextView newNoteEditText;
    private NotesAdapter adapter;
    private HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        newNoteEditText = findViewById(R.id.new_note_edit_text);

        RecyclerView recyclerView = findViewById(R.id.notes_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NotesAdapter();
        recyclerView.setAdapter(adapter);

        NoteDaoRepository noteDaoRepository = AppDatabaseCreator.create(getApplicationContext()).noteDao();
        final HomeService homeService = new HomeService(noteDaoRepository);

        ViewModelProvider.Factory factory = new HomeViewModelFactory(homeService);
        ViewModelProvider viewModelProvider = ViewModelProviders.of(this, factory);
        homeViewModel = viewModelProvider.get(HomeViewModel.class);

        newNoteEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String newNoteText = v.getText().toString();
                if (newNoteText.isEmpty()) {
                    return true;
                } else {
                    homeViewModel.insertNewNote(newNoteText);
                    v.setText("");
                    return false;
                }
            }
        });

        homeViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                adapter.update(notes);
            }
        });
    }

    private static class HomeViewModelFactory implements ViewModelProvider.Factory {
        private final HomeService homeService;

        HomeViewModelFactory(HomeService homeService) {
            this.homeService = homeService;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> aClass) {
            try {
                Constructor<T> constructor = aClass.getDeclaredConstructor(HomeService.class);
                return constructor.newInstance(homeService);
            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
