package com.example.piechartapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DateActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    TextView textViewDate;
    DBClass database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);


        textViewDate = findViewById(R.id.textViewDate);
        textViewDate.setOnClickListener((View view)-> {

            showDatePicker();
        });
    }

    private void showDatePicker() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,  this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        database = Room.databaseBuilder(
                getApplicationContext(),DBClass.class,"NewSampleDB.db"
        ).build();
        SampleDao sampleDao = database.sampleDao();

        String newDate = (month+1)+"-"+dayOfMonth+"-"+year;
        textViewDate.setText(newDate);
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-d-yyyy");
            LocalDate date = LocalDate.parse(newDate, formatter);
            Log.d("TAG", String.valueOf(date));
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.execute(()->{
                sampleDao.insertSampleData(new SampleEntity(String.valueOf(date)));

                List<SampleEntity> allData=  sampleDao.getAllData();

                Log.d("TAG", ""+filterByMonth(allData).size());
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public ArrayList<SampleEntity> filterByMonth(List<SampleEntity> arrayList){

        Date date= new Date();
        LocalDate todayDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = todayDate.getMonthValue();

        ArrayList<SampleEntity> allData = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        for(SampleEntity sampleEntity:arrayList){
            LocalDate localDate = LocalDate.parse(sampleEntity.getDate(), formatter);

            if(localDate.getMonthValue() == month)
                allData.add(sampleEntity);
        }

        return allData;
    }

}