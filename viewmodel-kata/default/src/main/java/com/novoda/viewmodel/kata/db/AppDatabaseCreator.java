package com.novoda.viewmodel.kata.db;

import android.arch.persistence.room.Room;
import android.content.Context;

public class AppDatabaseCreator {

    private static final String DB_NAME = "notes_db";

    public static AppDatabase create(Context applicationContext) {
        return Room.databaseBuilder(applicationContext, AppDatabase.class, DB_NAME).build();

    }
}
