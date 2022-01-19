package com.example.lec2demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
            int numTix = Integer.parseInt(editTextNumTxt.getText().toString());
            int index = spinnerConcertType.getSelectedItemPosition();
            double cost = 0;

            switch (index){
                case 0:
                    cost = numTix*79.99;
                    break;
                case 1:
                    cost = numTix*69.99;
                    break;
                case 2:
                    cost = numTix*59.99;
                    break;
            }

            //Send Results using Intent
            Intent myResults = new Intent(this,ResultsActivity.class);

            //Use a Bundle within Intent

            Bundle bundle = new Bundle();
            bundle.putInt("NUMTIX",numTix);
            bundle.putString("TYPE",spinnerConcertType.getSelectedItem().toString());
            bundle.putDouble("COST",cost);

            //Adding Bundle to Intent
            myResults.putExtras(bundle);

            //Adding Bundle to StartActivity
            startActivity(myResults);



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