package com.example.lec2demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Spinner spinnerConcertType;
    EditText editTextNumTxt;
    Button btnCalcCost;

    final String TAG = "Concert Dem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"Stared Concert Booking");

        btnCalcCost = findViewById(R.id.btnCalcCost);
        editTextNumTxt = findViewById(R.id.editTextNumTxt);

        spinnerConcertType = findViewById(R.id.spinnerConcertType);

        btnCalcCost.setOnClickListener((View view) -> {
    if(editTextNumTxt.getText().toString().isEmpty()){
        Log.d(TAG,"Inside Btn Empty Function");
        Toast.makeText(this, "Number of tickets Required", Toast.LENGTH_SHORT).show();
    }
    else{
        try {

        }
        catch (Exception e)
        {
            Log.d(TAG,e.getMessage());
            ///Log.d(TAG,e.printStackTrace());
            Toast.makeText(this, "Enter valid Input",
                    Toast.LENGTH_SHORT).show();
            e.printStackTrace();

        }
    }
        });

    }
}