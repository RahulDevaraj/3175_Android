package com.example.mid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity {

    ArrayList<String> arrayList = new ArrayList<>(
            Arrays.asList("1","2","3","4","5","6")
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        GridClass gridClass = new GridClass(arrayList);
        GridView gridView = findViewById(R.id.grid1);
        gridView.setAdapter(gridClass);

        gridView.setNumColumns(2);
        TextView textView = findViewById(R.id.textViewResult);
        Log.d("TAG","reached");

        gridView.setOnItemClickListener((AdapterView<?> adapterView, View view, int i, long l)-> {

            textView.setText(""+(i+1));
        });

    }
}