package com.novoda.viewmodel.kata.home;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.widget.TextView;

import com.novoda.viewmodel.kata.R;
import com.novoda.viewmodel.kata.data.Note;
import com.novoda.viewmodel.kata.home.presenter.HomePresenter;
import com.novoda.viewmodel.kata.home.viewmodel.HomeViewModel;
import com.novoda.viewmodel.kata.home.viewmodel.HomeViewModelFactory;

import java.util.List;

public class HomeActivity extends LifecycleActivity {

    private HomePresenter presenter;
    private TextView newNoteEditText;
    private NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        newNoteEditText = findViewById(R.id.new_note_edit_text);

        RecyclerView recyclerView = findViewById(R.id.notes_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NotesAdapter();
        recyclerView.setAdapter(adapter);

        HomeViewModelFactory factory = new HomeViewModelFactory(getApplicationContext());
        final HomeViewModel model = ViewModelProviders.of(this, factory).get(HomeViewModel.class);

        model.getNotes().observe(this, notesChanged);

        newNoteEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String newNoteText = v.getText().toString();
                if (newNoteText.isEmpty()) {
                    return true;
                } else {
                    model.insertNote(newNoteText);
                    v.setText("");
                    return false;
                }
            }
        });
    }

    private final Observer<List<Note>> notesChanged = new Observer<List<Note>>() {
        @Override
        public void onChanged(@Nullable List<Note> notes) {
            if (notes != null) {
                adapter.update(notes);
            }
        }
    };
}

