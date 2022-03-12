package com.example.midsemexamprep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RadioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        RadioGroup radioGroup =  findViewById(R.id.radioBtnGroup);
        TextView textView = findViewById(R.id.textViewRadio);
        Log.d("TAG","TEst");

        radioGroup.setOnCheckedChangeListener((RadioGroup newRadioGroup, int i) -> {

            if(i == R.id.radioButton1){
                textView.setText("Radio Button 1");
            }
            else if(i == R.id.radioButton2){
                textView.setText("Radio Button 2");
            }
        });

    }
}