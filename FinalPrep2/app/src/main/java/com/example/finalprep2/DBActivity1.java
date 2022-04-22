package com.example.finalprep2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalprep2.database.DatabaseClass;
import com.example.finalprep2.databinding.ActivityDbactivity1Binding;
import com.example.finalprep2.entities.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DBActivity1 extends AppCompatActivity {
    DatabaseClass database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDbactivity1Binding binding = ActivityDbactivity1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Student> students = readStudentsCSV();
        database = Room.databaseBuilder(getApplicationContext(),DatabaseClass.class,"TESTDB.db").build();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()-> {

            database.studentDao().insertStudents(students);

            //database.studentDao().deleteWithId("230123");
            database.studentDao().deleteStudentsStartingWith3();
            List<Student> studentListFromDB = database.studentDao().getAllData();




            runOnUiThread(()->{
                TextView textView =binding.textViewDBResult;
                textView.setText(""+studentListFromDB.size()+" Added ");
            });


        });



    }

    public List<Student> readStudentsCSV(){
        List<Student> students = new ArrayList<>();

        InputStream inputStream = getResources().openRawResource(R.raw.students);
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream)
        );

        try{
            String eachLine;

            if((eachLine  = bufferedReader.readLine())!=null);

            while((eachLine  = bufferedReader.readLine())!=null){
                String tokens[] = eachLine.split(",");
                String id = tokens[0];
                String name = tokens[1];
                String dept = tokens[2];


                Student student = new Student(id,name,dept);
                students.add(student);

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        return students;
    }
}