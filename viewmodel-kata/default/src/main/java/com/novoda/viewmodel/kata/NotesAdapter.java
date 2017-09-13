package com.novoda.viewmodel.kata;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.novoda.viewmodel.kata.data.Note;

import java.util.ArrayList;
import java.util.List;

class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {

    private List<Note> notes = new ArrayList<>();

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_note_item, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        holder.update(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    void add(Note note) {
        notes.add(note);
    }

    static class NoteViewHolder extends RecyclerView.ViewHolder {

        private final TextView titleTextView;

        NoteViewHolder(View rootView) {
            super(rootView);
            titleTextView = rootView.findViewById(R.id.note_text_text_view);
        }

        void update(Note note) {
            titleTextView.setText(note.text());
        }
    }
}
