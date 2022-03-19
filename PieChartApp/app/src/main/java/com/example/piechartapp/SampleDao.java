package com.example.piechartapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


@Dao
public interface SampleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertSampleData(SampleEntity sampleEntity);

    @Query("SELECT * FROM SAMPLETABLE")
    List<SampleEntity> getAllData();
}
