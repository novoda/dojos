package com.novoda.room.kata;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.novoda.room.kata.dao.PhotoDAO;
import com.novoda.room.kata.database.RoomKataDatabase;
import com.novoda.room.kata.entity.Photo;

import java.util.List;

class RoomKata {
    private PhotoDAO photoDAO;

    public void initialize(Context context) {
        RoomKataDatabase roomKataDatabase = Room.inMemoryDatabaseBuilder(context, RoomKataDatabase.class)
                .allowMainThreadQueries()
                .build();
        photoDAO = roomKataDatabase.photoDAO();
    }

    public List<Photo> retrieveAll() {
        return photoDAO.getAll();
    }

    public void insert(Photo photo) {
        photoDAO.insert(photo);
    }

    public void insert(List<Photo> photos) {
        photoDAO.insertAll(photos);
    }

    public void delete(Photo photo) {
        photoDAO.delete(photo);
    }

    public Photo retrieveWithId(int id) {
        return photoDAO.loadWithId(id);
    }
}
