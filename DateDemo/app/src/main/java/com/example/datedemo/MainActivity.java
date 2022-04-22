package com.example.datedemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.datedemo.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Dog> DogList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ReadDogData();
        binding.recyclerViewDogItems.setLayoutManager(new LinearLayoutManager(this));
        //
        //binding.recyclerViewDogItems.setAdapter(new DogAdapter(DogList));

        binding.recyclerViewDogItems.setAdapter(new DogAdapter(DogList, new DogAdapter.OnItemClickListener() {
            @Override
            public void onItemCick(int index) {
                String dogBreed = DogList.get(index).getDogBreed();
                String dogName = DogList.get(index).getDogName();
                LocalDate localDate = DogList.get(index).getDob();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
                String dobString = formatter.format(localDate);

                binding.txtViewAdoptionSumary.setText("Adopted Dog "+dogName+"\n"+
                        "Adopted Breed "+dogBreed+"\n"+
                        "DOB "+dobString+"\n");
            }
        }));

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void ReadDogData() {
        DogList = new ArrayList<>();

        InputStream inputStream = getResources().openRawResource(R.raw.doginfo);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String CSVLine;
            //if you have a header line, you must read it first before you enter the loop
            //for reading and parsing data lines

            while ((CSVLine = reader.readLine()) != null) {
                String[] DogFields = CSVLine.split(",");
                int id = Integer.parseInt(DogFields[0]);
                String dogPicName = DogFields[1];
                String dogBreed = DogFields[2];
                String dogName = DogFields[3];
                String dobStr = DogFields[4];
                //need to parse dobStr to convert to LocalDate

                int dogDrawable = getResources().getIdentifier(dogPicName,"drawable",getPackageName());

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
                LocalDate dob = LocalDate.parse(dobStr,formatter);

                Dog eachDog = new Dog(id,dogBreed,dogName,dogDrawable,dob);
                DogList.add(eachDog);

            }
        } catch (Exception ex) {
            Log.d("DATEDEMO", ex.getMessage());
        }
    }
}