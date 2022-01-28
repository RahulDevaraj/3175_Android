package com.example.lec3demo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    TextView textViewResults;
    EditText editTextInputWeight;
    Button buttonConvertWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setLogo(R.mipmap.ic_launcher_wt_round);

        actionBar.setTitle(R.string.txtTitle);

        radioGroup = findViewById(R.id.radGropConvType);
        editTextInputWeight = findViewById(R.id.editTextInputWeight);
        buttonConvertWeight = findViewById(R.id.btnConvertWt);
        textViewResults = findViewById(R.id.textViewResults);

        buttonConvertWeight.setOnClickListener((View view)-> {
            if(radioGroup.getCheckedRadioButtonId() == -1)
            {
                Toast.makeText(MainActivity.this, "Please Select an Option", Toast.LENGTH_SHORT).show();
            }
            else if(editTextInputWeight.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Please ENter baggage weight", Toast.LENGTH_SHORT).show();
            }
            else{
                double inputWt,outputWt=0;
                try{
                    inputWt = Double.parseDouble(editTextInputWeight.getText().toString());

                    if(inputWt <0)
                        Toast.makeText(MainActivity.this, "Weight cannot be -ve", Toast.LENGTH_SHORT).show();
                    else if(radioGroup.getCheckedRadioButtonId() == R.id.radBtnKgsToLbs)
                    {
                        if(inputWt > 500)
                            Toast.makeText(this, "Input Wight cannot be more than 500 Kgs",
                                    Toast.LENGTH_SHORT).show();
                        else
                        {
                            outputWt = inputWt * 2.2;
                            textViewResults.setText(String.format("Converted wt: %.2f Lbs",outputWt));
                        }
                    }
                    else if(radioGroup.getCheckedRadioButtonId() == R.id.radBtnLbsToKgs)
                    {
                        if(inputWt > 1000)
                            Toast.makeText(this, "Input Wight cannot be more than 1000Lbs",
                                    Toast.LENGTH_SHORT).show();
                        else
                        {
                            outputWt = inputWt / 2.2;
                            textViewResults.setText(String.format("Converted wt: %.2f Kgs",outputWt));
                        }
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }


        });



    }
}