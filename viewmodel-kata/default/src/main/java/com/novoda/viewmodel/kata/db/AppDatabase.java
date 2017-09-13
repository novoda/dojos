package com.novoda.viewmodel.kata.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.novoda.viewmodel.kata.db.dao.NoteDao;
import com.novoda.viewmodel.kata.db.entity.NoteEntity;

@Database(entities = {NoteEntity.class}, version = 1)
abstract class AppDatabase extends RoomDatabase {

    public abstract NoteDao noteDao();

}
