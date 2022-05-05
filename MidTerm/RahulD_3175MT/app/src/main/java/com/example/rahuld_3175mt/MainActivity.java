package com.example.rahuld_3175mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

//    ArrayList<String> activityNames = new ArrayList<>(
//            Arrays.asList("Soccer Goals","Theater Acts","Karate Kicks"));
//    ArrayList<Integer> activityPics = new ArrayList<>(
//            Arrays.asList(R.drawable.soccer,R.drawable.theatre,R.drawable.karate));
//    ArrayList<Double> activityCosts = new ArrayList<>(
//            Arrays.asList(165.99,179.99,189.99));

    ArrayList<String> arrayListCampTimes = new ArrayList<>
            (Arrays.asList("Morning Camp","Afternoon Camp"));

    ArrayList<Integer> arrayListCampTimesPics = new ArrayList<>
            (Arrays.asList(R.drawable.amicon,R.drawable.pmicon));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListAdapter listAdapter = new ListAdapter(arrayListCampTimes,arrayListCampTimesPics);
        ListView listView = findViewById(R.id.listViewShowTimes);

        listView.setAdapter(listAdapter);


        listView.setOnItemClickListener((AdapterView<?> adapterView, View view, int i, long l)-> {
            EditText editTextParentName = findViewById(R.id.editTextParentName);

            if(editTextParentName.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this,
                        "Please Enter Parent Name before clicking on the TIme", Toast.LENGTH_SHORT).show();
            }
            else{

                Bundle bundle = new Bundle();
                bundle.putString("PARENT",editTextParentName.getText().toString());
                bundle.putString("TIME",arrayListCampTimes.get(i));

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtras(bundle);

                startActivity(intent);

            }

        });
    }
}