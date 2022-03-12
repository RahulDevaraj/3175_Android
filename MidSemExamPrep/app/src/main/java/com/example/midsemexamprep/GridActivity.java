package com.example.midsemexamprep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class GridActivity extends AppCompatActivity {

    int clickedItem = -1;
    TextView textView;
    ArrayList<Integer> arrayListPic = new ArrayList<>
            (Arrays.asList(R.drawable.gorilla,R.drawable.panda,R.drawable.bunnysplash,R.drawable.elephant,R.drawable.eagle,R.drawable.panther));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);



        GridClass gridClass = new GridClass(arrayListPic);
        textView = findViewById(R.id.textViewGridResult);
        GridView gridView = findViewById(R.id.gridView);

        gridView.setAdapter(gridClass);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener((AdapterView<?> adapterView, View view, int i, long l) -> {

            textView.setText(i+"");
            clickedItem = i;

        });

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        clickedItem = sharedPreferences.getInt("INT",-1);

        if(clickedItem != -1)
            try {
                textView.setText(clickedItem+"");
            }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.d("TAG","in catch");
        }




    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("INT",clickedItem);
        editor.commit();
    }
}