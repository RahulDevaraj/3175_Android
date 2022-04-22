package com.example.finalprep2.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalprep2.adapter.DogGridAdapter;
import com.example.finalprep2.databinding.ActivityMain4Binding;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.finalprep2.Dog;
import com.example.finalprep2.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {
    int clickedItem = -1;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMain4Binding binding = ActivityMain4Binding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        List<Dog> dogList = readDataCSV();

        GridView gridView = binding.gridView;
        gridView.setAdapter(new DogGridAdapter(dogList));
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener((AdapterView<?> adapterView, View view, int i, long l) -> {
            TextView textView = binding.textViewGridResult;
            textView.setText(dogList.get(i).getDogName());
            clickedItem = i;

        });

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        clickedItem = sharedPreferences.getInt("DOGID",-1);
        if(clickedItem!=-1)
        {
            TextView textView = binding.textViewGridResult;
            textView.setText(dogList.get(clickedItem).getDogName());
        }



    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("DOGID",clickedItem);
        editor.commit();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<Dog> readDataCSV(){
        List<Dog> dogList = new ArrayList<>();

        InputStream inputStream = getResources().openRawResource(R.raw.doginfo);
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream)
        );

        try{
            String eachLine;

            while((eachLine  = bufferedReader.readLine())!=null){
                String tokens[] = eachLine.split(",");
                int id = Integer.parseInt(tokens[0]);
                int dogPic = getResources().getIdentifier(tokens[1],"drawable",getPackageName());
                String dogBreed = tokens[2];
                String dogName = tokens[3];

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
                LocalDate date = LocalDate.parse(tokens[4],formatter);

                Dog dog = new Dog(id,dogPic,dogBreed,dogName,date);
                dogList.add(dog);

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



        return dogList;
    }
}