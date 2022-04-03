package com.example.lec8dbdemo.databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.lec8dbdemo.interfaces.GradeDao;
import com.example.lec8dbdemo.interfaces.StudentDao;
import com.example.lec8dbdemo.interfaces.StudentGradeDao;
import com.example.lec8dbdemo.model.Grade;
import com.example.lec8dbdemo.model.Student;

@Database(entities = {Student.class, Grade.class},version = 1,exportSchema = false)
public abstract class StudentsDatabase extends RoomDatabase {//Make the DB Class abstract
    public abstract StudentDao studentDao(); //just put the Daos in here
    public abstract GradeDao gradeDao(); //just put the Daos in here
    public abstract StudentGradeDao studentGradeDao();
}
