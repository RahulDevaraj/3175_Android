package com.example.finalprep2.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.finalprep2.entities.DogDbEntity;

import java.util.List;

@Dao
public interface DogDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllDogData(List<DogDbEntity> dogDbEntityList);

    @Query("SELECT * FROM dogtable WHERE dogid > :id")
    List<DogDbEntity> getAllDogData(int id);

    @Query("SELECT * FROM dogtable WHERE dogid = :id")
    DogDbEntity getSelectedDogData(int id);

    @Query("UPDATE dogtable SET dogname = :dname WHERE dogid = :id")
    int updateSelectedDog(String dname,int id);
}
