package com.novoda.room.kata.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.novoda.room.kata.entity.Photo;

import java.util.List;

@Dao
public interface PhotoDAO {
    @Query("SELECT * FROM photo")
    List<Photo> getAll();

    @Insert
    void insertAll(List<Photo> photos);

    @Insert
    void insert(Photo photo);

    @Delete
    void delete(Photo photo);

    @Query("SELECT * FROM photo WHERE id = :id")
    Photo loadWithId(int id);
}
