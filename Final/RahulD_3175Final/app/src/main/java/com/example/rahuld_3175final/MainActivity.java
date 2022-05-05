package com.example.rahuld_3175final;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.rahuld_3175final.databinding.ActivityMainBinding;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    List<Course> courseList;
    CourseDatabase database;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        database = Room.databaseBuilder(getApplicationContext(),CourseDatabase.class,"courses.db").build();

        courseList = readCSV();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {

            database.courseDao().insertData(convertData(courseList));

            runOnUiThread(()->{
                RecyclerView recyclerView = binding.recyclerViewCourses;
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this , 2);
                recyclerView.setLayoutManager(gridLayoutManager);

                 recyclerView.setAdapter(new RecyclerViewAdapter(courseList));
        recyclerView.setAdapter(new RecyclerViewAdapter(courseList, new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int index) {
                executorService.execute(()->{
                    database.courseDao().updateData(courseList.get(index).getCourseName());
                });
            }
        }));

                Button button = binding.btnViewCartSummary;
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
startActivity(new Intent(MainActivity.this,PurchaseSummary.class));
                    }
                });

            });

        });
//        RecyclerView recyclerView = binding.recyclerViewCourses;
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this , 2);
//        recyclerView.setLayoutManager(gridLayoutManager);

       // recyclerView.setAdapter(new RecyclerViewAdapter(courseList));
//        recyclerView.setAdapter(new RecyclerViewAdapter(courseList, new RecyclerViewAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int index) {
//
//            }
//        }));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    List<Course> readCSV(){
        List<Course> courseList = new ArrayList<>();

        InputStream inputStream=getResources().openRawResource(R.raw.courses);
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));

        try{
            String courseLine;
            if((courseLine = bufferedReader.readLine())!=null);

            while((courseLine = bufferedReader.readLine())!=null)
            {
                String tokens[] = courseLine.split(",");


                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                LocalDate localDate = LocalDate.parse(tokens[0],formatter);

                String courseName = tokens[1];
                int courseDrawable = getResources().getIdentifier(tokens[2],"drawable",getPackageName());
                Double coursePrice = Double.parseDouble(tokens[3]);
                int courseDiscount = Integer.parseInt(tokens[4]);

                Log.d("TAG",tokens.length+""+tokens[1]);
                Course course = new Course(localDate,courseName,courseDrawable,coursePrice,courseDiscount,0);

                courseList.add(course);
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


        return courseList;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    List<CourseEntity> convertData(List<Course> courseList){
        List<CourseEntity> list =new ArrayList<>();

        for(Course course:courseList)
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            String date = formatter.format(course.getCourseDate());
            list.add(new CourseEntity(course.getCourseName(),date,course.getCourseDrawable(),course.getCoursePrice(),
                    0,course.getCourseDiscount()));
        }
        return list;
    }

//    List<Course> convertData(List<CourseEntity> courseList){
//        List<CourseEntity> list =new ArrayList<>();
//
//        for(CourseEntity course:courseList)
//        {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
//            String date = formatter.format(course.getCourseDate());
//            list.add(new CourseEntity(course.getCourseName(),date,course.getCourseDrawable(),course.getCoursePrice(),
//                    0,course.getCourseDiscount()));
//        }
//        return list;
//    }
}