package com.example.lec2demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultsActivity extends AppCompatActivity {

    final String TAG = "Concert Dem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        try {
            Bundle bundle = getIntent().getExtras(); //GEtting the Extras
            double cost = bundle.getDouble("COST",0);
            String type = getIntent().getExtras().getString("TYPE","empty");
            int numTIx = bundle.getInt("NUMTIX",0);

            DecimalFormat decimalFormat = new DecimalFormat("$#.##");

            String resultString = "Concert Type: "+type+"\n"+
                    "Num Tix: "+numTIx+"\n"+
                    "Cost: "+decimalFormat.format(cost)+"\n";

            TextView textViewResults = findViewById(R.id.textViewResults);
            textViewResults.setText(resultString);

            //Gravity Anotherway

           // textViewResults.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
        }
        catch (Exception e)
        {
            Log.e(TAG,e.getMessage());
            e.printStackTrace();

        }
    }
}