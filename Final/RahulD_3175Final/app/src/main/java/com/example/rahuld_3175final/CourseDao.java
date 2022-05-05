package com.example.rahuld_3175final;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CourseDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertData(List<CourseEntity> list);

    @Query("UPDATE courses SET coursenumsessions = coursenumsessions+1 WHERE coursename = :cname")
    int updateData(String cname);

    @Query("SELECT * FROM courses WHERE coursenumsessions > :c")
    public List<CourseEntity> getData(int c);
}
