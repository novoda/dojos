package com.novoda.viewmodel.kata.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import com.novoda.viewmodel.kata.R;
import com.novoda.viewmodel.kata.data.Note;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView recyclerView = findViewById(R.id.notes_recycler_view);
        final EditText newNoteEditText = findViewById(R.id.new_note_edit_text);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final NotesAdapter adapter = new NotesAdapter();
        recyclerView.setAdapter(adapter);

        newNoteEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String newNoteText = v.getText().toString();
                if (newNoteText.isEmpty()) {
                    return true;
                } else {
                    adapter.add(new Note(newNoteText));
                    v.setText("");
                    return false;
                }
            }
        });
    }
}

