package com.novoda.room.kata.dao;

import com.novoda.room.kata.entity.Photo;

import java.util.List;

public interface PhotoDAO {
    List<Photo> getAll();

    void insertAll(List<Photo> photos);

    void insert(Photo photo);

    void delete(Photo photo);

    Photo loadWithId(int id);
}
