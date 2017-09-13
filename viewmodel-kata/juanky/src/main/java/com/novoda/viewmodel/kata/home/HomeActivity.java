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
import com.novoda.viewmodel.kata.home.viewmodel.HomeViewModel;
import com.novoda.viewmodel.kata.home.viewmodel.HomeViewModelFactory;

import java.util.List;

public class HomeActivity extends LifecycleActivity{

    private NotesAdapter adapter;
    private HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView newNoteEditText = findViewById(R.id.new_note_edit_text);

        RecyclerView recyclerView = findViewById(R.id.notes_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NotesAdapter();
        recyclerView.setAdapter(adapter);

        newNoteEditText.setOnEditorActionListener(onNoteAddedListener);

        homeViewModel = ViewModelProviders.of(this, HomeViewModelFactory.newInstance(this)).get(HomeViewModel.class);
    }

    private final TextView.OnEditorActionListener onNoteAddedListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            String newNoteText = v.getText().toString();
            if (newNoteText.isEmpty()) {
                return true;
            } else {
                homeViewModel.insetNewNote(newNoteText);
                v.setText("");
                return false;
            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        homeViewModel.getAllNotes().observe(this, observeNotes);
    }

    private final Observer<List<Note>> observeNotes = new Observer<List<Note>>() {
        @Override
        public void onChanged(@Nullable List<Note> notes) {
            adapter.update(notes);
        }
    };

}

