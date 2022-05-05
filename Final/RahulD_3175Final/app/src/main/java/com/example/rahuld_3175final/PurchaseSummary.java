package com.example.rahuld_3175final;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rahuld_3175final.databinding.ActivityPurchaseSummaryBinding;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PurchaseSummary extends AppCompatActivity {
    CourseDatabase database;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPurchaseSummaryBinding binding =  ActivityPurchaseSummaryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView textView = binding.txtViewTitle2;
        textView.setText("Rahul Devarajan Raj - 300342528 - 3175 Final");

        database = Room.databaseBuilder(getApplicationContext(),CourseDatabase.class,"courses.db").build();



        ListView listView = binding.listViewPurchedCourses;
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            List<CourseEntity> list1 = database.courseDao().getData(0);

            runOnUiThread(()->{
                List<Course> courses = convertData(list1);
                Log.d("TAG1",courses.size()+"");
                listView.setAdapter(new ListViewAdapter(courses));
            });

        });




    }

        @RequiresApi(api = Build.VERSION_CODES.O)
        List<Course> convertData(List<CourseEntity> courseList){

        List<Course> list =new ArrayList<>();

        for(CourseEntity course:courseList)
        {
                        list.add(new Course(LocalDate.now(),
                    course.getCoursename(),
                    1,
                    course.getCourseprice(),

                    course.getCoursediscount(),course.getCoursenumsessions()));
        }
        return list;
    }
}