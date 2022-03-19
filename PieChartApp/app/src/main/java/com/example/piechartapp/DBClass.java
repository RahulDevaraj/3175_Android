package com.example.piechartapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {SampleEntity.class},version = 1,exportSchema = false)
public abstract class DBClass extends RoomDatabase {
    public abstract SampleDao sampleDao();
}
