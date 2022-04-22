package com.example.finalprep2.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.example.finalprep2.Dog;
import com.example.finalprep2.R;
import com.example.finalprep2.adapter.DogAdapter;
import com.example.finalprep2.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Dog> dogList;
    Toast currentToast = null;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dogList = readDataCSV();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(gridLayoutManager);

//        DogAdapter dogAdapter = new DogAdapter(dogList);
//        recyclerView.setAdapter(dogAdapter);

        DogAdapter dogAdapter = new DogAdapter(dogList, new DogAdapter.OnItemClickListener() {
            @Override
            public void OnNameClick(int index) {
                binding.textViewResult.setText(dogList.get(index).getDogName());
                //Toast.makeText(getApplicationContext(), dogList.get(index).getDogName().toString(), Toast.LENGTH_SHORT).show();
                if(currentToast!=null)
                    currentToast.cancel();
                currentToast = Toast.makeText(getApplicationContext(),dogList.get(index).getDogName().toString(),Toast.LENGTH_SHORT);
                currentToast.show();
            }
        });
        recyclerView.setAdapter(dogAdapter);




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