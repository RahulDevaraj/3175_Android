package com.example.lec8dbdemo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.lec8dbdemo.R;
import com.example.lec8dbdemo.databases.StudentsDatabase;
import com.example.lec8dbdemo.databinding.ActivityMainBinding;
import com.example.lec8dbdemo.interfaces.StudentDao;
import com.example.lec8dbdemo.model.Student;
import com.example.lec8dbdemo.adapters.StudentAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    StudentsDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        List<Student> allStudents = readStudentsCSV();
        //ListView listViewStudents = findViewById(R.id.listViewStudents);
        ListView listViewStudents = binding.listViewStudents;

        database = Room.databaseBuilder(
                getApplicationContext(),StudentsDatabase.class,"Students.db"
        ).build();
        StudentDao studentDao = database.studentDao();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            try {
                studentDao.insertStudentsFromList(allStudents);
                List<Student> allDbStudents = studentDao.getAllStudents();
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        StudentAdapter studentAdapter = new StudentAdapter(allStudents);
        listViewStudents.setAdapter(studentAdapter);
    }

    private List<Student> readStudentsCSV(){
        List<Student> studentsList = new ArrayList<>();

        InputStream inputStream = getResources().openRawResource(R.raw.students);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String studentLine;
            if ((studentLine = bufferedReader.readLine())!=null){
                //Disposing the headings
            }
            while ((studentLine = bufferedReader.readLine())!=null){
                String[] eachLine = studentLine.split(",");
                Student student = new Student(eachLine[0],eachLine[1],eachLine[2]);
                studentsList.add(student);
            }

        }
        catch (IOException e)
        {
            throw  new RuntimeException("Error in file read "+e);
        }
        finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return studentsList;
    }

}