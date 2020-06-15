package com.example.roomwords;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insert(Word word);

    @Query("DELETE from word_table")
    public void deleteAll();

    @Query("Select * from word_table Order By word ASC")
    public LiveData<List<Word>> getAllWords();
}
