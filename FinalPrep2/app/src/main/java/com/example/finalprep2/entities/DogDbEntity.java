package com.example.finalprep2.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dogtable")
public class DogDbEntity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "dogid")
    int dogId;

    @NonNull
    @ColumnInfo(name = "dogname")
    String dogName;

    public DogDbEntity(int dogId, @NonNull String dogName) {
        this.dogId = dogId;
        this.dogName = dogName;
    }

    public int getDogId() {
        return dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    @NonNull
    public String getDogName() {
        return dogName;
    }

    public void setDogName(@NonNull String dogName) {
        this.dogName = dogName;
    }

    @Override
    public String toString() {
        return "DogDbEntity{" +
                "dogId=" + dogId +
                ", dogName='" + dogName + '\'' +
                '}';
    }
}
