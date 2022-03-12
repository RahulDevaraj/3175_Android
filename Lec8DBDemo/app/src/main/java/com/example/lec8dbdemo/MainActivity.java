package com.example.lec8dbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Student> allStudents = readStudentsCSV();
        ListView listViewStudents = findViewById(R.id.listViewStudents);

        StudentAdapter studentAdapter = new StudentAdapter(allStudents);
        listViewStudents.setAdapter(studentAdapter);
    }

    private List<Student> readStudentsCSV(){
        List<Student> studentsList = new ArrayList<>();

        InputStream inputStream = getResources().openRawResource(R.raw.students);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String studentLine;
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