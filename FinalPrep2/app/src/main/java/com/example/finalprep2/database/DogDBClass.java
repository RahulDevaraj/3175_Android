package com.example.finalprep2.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.finalprep2.dao.DogDao;
import com.example.finalprep2.entities.DogDbEntity;

@Database(entities = {DogDbEntity.class},version = 1,exportSchema = false)
public abstract class DogDBClass extends RoomDatabase {
    public abstract DogDao dogDao();
}
