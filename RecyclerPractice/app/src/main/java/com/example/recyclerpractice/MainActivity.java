package com.example.recyclerpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<DataClass> classList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        classList = addData();
        ImageView imageViewResult = findViewById(R.id.imageViewResult);
        TextView textViewResult = findViewById(R.id.textViewResult);

        //Keep in mind linear layout is necessary
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(classList);
        recyclerView.setLayoutManager(linearLayoutManager);
        //recyclerView.setAdapter(recyclerViewAdapter);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(classList, new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int i) {
                if(i==-1){
                    imageViewResult.setImageResource(0);
                    textViewResult.setText("");
                }
                else{
                    imageViewResult.setImageResource(classList.get(i).getImage());
                    textViewResult.setText(classList.get(i).getText());
                }
            }
        });
        recyclerView.setAdapter(myAdapter);

    }

    public List<DataClass> addData(){
        List<DataClass> classList = new ArrayList<>();

        classList.add(new DataClass(R.drawable.bunnysplash,"Bunny"));
        classList.add(new DataClass(R.drawable.eagle,"Eagle"));
        classList.add(new DataClass(R.drawable.elephant,"Elephant"));
        classList.add(new DataClass(R.drawable.gorilla,"Gorilla"));

        return  classList;
    }


}