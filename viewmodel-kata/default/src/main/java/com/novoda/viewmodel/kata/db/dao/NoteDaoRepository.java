package com.novoda.viewmodel.kata.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.novoda.viewmodel.kata.db.entity.NoteEntity;

import java.util.List;

@Dao
public interface NoteDaoRepository {

    @Query("SELECT * FROM notes")
    List<NoteEntity> getAll();

    @Insert
    void insert(NoteEntity noteEntity);
}
