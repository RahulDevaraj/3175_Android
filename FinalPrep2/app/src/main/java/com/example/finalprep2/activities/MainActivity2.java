package com.example.finalprep2.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.finalprep2.Dog;
import com.example.finalprep2.R;
import com.example.finalprep2.adapter.DogListAdapter;
import com.example.finalprep2.databinding.ActivityMain2Binding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    List<Dog> dogList;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMain2Binding binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dogList = readDataCSV();
        ListView listView = binding.listViewDog;
        DogListAdapter dogListAdapter = new DogListAdapter(dogList);

        listView.setAdapter(dogListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                binding.textViewResults2.setText(dogList.get(i).getDogName());
                Intent myResults = new Intent(MainActivity2.this,MainActivity3.class);
                Bundle bundle = new Bundle();
                bundle.putString("DOGNAME",dogList.get(i).getDogName());
                bundle.putInt("DOGID",dogList.get(i).getId());

                myResults.putExtras(bundle);

                startActivity(myResults);


            }
        });




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