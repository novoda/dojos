package com.novoda.room.kata.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.novoda.room.kata.dao.PhotoDAO;
import com.novoda.room.kata.entity.Photo;

@Database(entities = {Photo.class}, version = 1)
public abstract class RoomKataDatabase extends RoomDatabase {

    public abstract PhotoDAO photoDAO();
}
