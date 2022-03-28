package com.example.lec8dbdemo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.example.lec8dbdemo.R;
import com.example.lec8dbdemo.databases.StudentsDatabase;
import com.example.lec8dbdemo.databinding.ActivityNextBinding;
import com.example.lec8dbdemo.interfaces.StudentDao;
import com.example.lec8dbdemo.model.Grade;
import com.example.lec8dbdemo.model.Student;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NextActivity extends AppCompatActivity {
    StudentsDatabase database;
    StringBuilder outputText = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNextBinding binding = ActivityNextBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot()); //VVIMP

        database = Room.databaseBuilder(getApplicationContext(),StudentsDatabase.class,"Students.db").build();

        outputText.append(String.format("%-10s%-10s%-10s\n","Id","Name","Dept"));

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()-> {
            int retValue = database.studentDao().deleteStudentWithId("312345");
            List<Student> students = database.studentDao().getAllStudents();

            List<Grade> gradeList = database.gradeDao().getAllGrades();

            for(Student student:students)
                outputText.append(String.format("%-10s%-10s%-10s\n",student.getStudentId(),
                        student.getStudentName(),
                        student.getStudentDept()));

            outputText.append("Displaying Grades..\n");
            outputText.append(String.format("%-10s%-10s%-10s\n","StudID","CourseID","Grades"));

            for(Grade grade:gradeList)
                outputText.append(String.format("%-10s%-10s%-10.2f\n",grade.getStudentId(),
                        grade.getCourseId(),
                        grade.getStudentGrade()));



            runOnUiThread(()->{
                binding.textViewSummary.setText(outputText);
            });
        });
    }
}