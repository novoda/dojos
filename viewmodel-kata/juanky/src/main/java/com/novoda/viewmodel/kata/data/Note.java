package com.novoda.viewmodel.kata.data;

public class Note {

    private final String text;

    public Note(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Note note = (Note) o;

        return text.equals(note.text);

    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }
}
