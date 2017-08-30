package com.novoda.room.kata.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.novoda.room.kata.entity.Photo;

import java.util.List;

@Dao
public interface PhotoDAO {
    @Query("select * from Photo")
    List<Photo> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Photo> photos);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Photo photo);

    @Delete
    void delete(Photo photo);

    @Query("select * from Photo where id is :id")
    Photo loadWithId(int id);
}
