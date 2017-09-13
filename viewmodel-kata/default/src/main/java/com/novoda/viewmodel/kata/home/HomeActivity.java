package com.novoda.viewmodel.kata.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.widget.TextView;

import com.novoda.viewmodel.kata.R;
import com.novoda.viewmodel.kata.data.Note;
import com.novoda.viewmodel.kata.db.AppDatabaseCreator;
import com.novoda.viewmodel.kata.db.dao.NoteDaoRepository;
import com.novoda.viewmodel.kata.home.presenter.HomeActionListener;
import com.novoda.viewmodel.kata.home.presenter.HomeDisplayer;
import com.novoda.viewmodel.kata.home.presenter.HomePresenter;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeDisplayer {

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

        NoteDaoRepository noteDaoRepository = AppDatabaseCreator.create(getApplicationContext()).noteDao();
        HomeService homeService = new HomeService(noteDaoRepository);
        presenter = new HomePresenter(this, homeService);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.startPresenting();
    }

    @Override
    public void attach(final HomeActionListener actionListener) {
        newNoteEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String newNoteText = v.getText().toString();
                if (newNoteText.isEmpty()) {
                    return true;
                } else {
                    actionListener.onNewNoteAdded(newNoteText);
                    v.setText("");
                    return false;
                }
            }
        });
    }

    @Override
    public void display(List<Note> notes) {
        adapter.update(notes);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stopPresenting();
    }
}

