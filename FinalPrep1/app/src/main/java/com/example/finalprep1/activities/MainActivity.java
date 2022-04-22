package com.example.finalprep1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalprep1.R;
import com.example.finalprep1.adapter.RecyclerViewStudentAdapter;
import com.example.finalprep1.database.StudentDatabase;
import com.example.finalprep1.databinding.ActivityMainBinding;
import com.example.finalprep1.entity.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Student> students = readFromCSV();

        StudentDatabase database = Room.databaseBuilder(getApplicationContext(),StudentDatabase.class,"StudentDB").build();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            database.studentDao().insertStudents(students);
            List<Student> studentsFromDB = database.studentDao().getAllStudnetsFromDB();

            runOnUiThread(()->{
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                //RecyclerViewStudentAdapter adapter = new RecyclerViewStudentAdapter(studentsFromDB);
                RecyclerView recyclerView = binding.recyclerViewStudents;
                recyclerView.setLayoutManager(linearLayoutManager);
                RecyclerViewStudentAdapter adapter = new RecyclerViewStudentAdapter(studentsFromDB, new RecyclerViewStudentAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int index) {
                        TextView textViewSummary = binding.textViewSummary;
                        textViewSummary.setText(studentsFromDB.get(index).getId().toString());
                    }

                    @Override
                    public void onItemClick2(int index) {
                        TextView textViewSummary = binding.textViewSummary;
                        textViewSummary.setText("Hello " +studentsFromDB.get(index).getName().toString());
                    }
                });
                recyclerView.setAdapter(adapter);
            });


        });

        Button button = binding.buttonChange;
        button.setOnClickListener((View view)-> {
            startActivity(new Intent(this,NextActivity.class));
        });



    }

    public List<Student> readFromCSV(){
        List<Student> students = new ArrayList<>();

        InputStream inputStream = getResources().openRawResource(R.raw.students);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try{
            String eachLine;
            if((eachLine = reader.readLine())!=null); //heading

            while((eachLine = reader.readLine())!=null) //heading
            {
                String token[] = eachLine.split(",");
                Student student = new Student(token[0],token[1],token[2]);
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