package com.novoda.room.kata;

import android.content.Context;
import android.util.Log;

import com.novoda.room.kata.dao.PhotoDAO;
import com.novoda.room.kata.entity.Photo;

import java.util.List;

class RoomKata {
    private PhotoDAO photoDAO;

    public void initialize(Context context) {
        Log.e("RoomKata", "Method 'initialize' is not implemented. We should instantiate a room database and get the PhotoDAO from it");
    }

    public List<Photo> retrieveAll() {
        throw new IllegalStateException("Method 'retrieveAll' is not implemented. We should have a functional PhotoDAO and delegate to it");
    }

    public void insert(Photo photo) {
        throw new IllegalStateException("Method 'insert(Photo)' is not implemented. We should have a functional PhotoDAO and delegate to it");
    }

    public void insert(List<Photo> photos) {
        throw new IllegalStateException("Method 'insert(List<Photo)' is not implemented. We should have a functional PhotoDAO and delegate to it");
    }

    public void delete(Photo photo) {
        throw new IllegalStateException("Method 'delete(Photo)' is not implemented. We should have a functional PhotoDAO and delegate to it");
    }

    public Photo retrieveWithId(int id) {
        throw new IllegalStateException("Method 'retrieveWithId(int)' is not implemented. We should have a functional PhotoDAO and delegate to it");
    }
}
