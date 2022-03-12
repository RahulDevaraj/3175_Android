package com.example.midsemexamprep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SpinnerResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_result);

        TextView textView = findViewById(R.id.textViewSpinnerResult);

        String text = getIntent().getExtras().getString("TEXT",null);
        int quantity = getIntent().getExtras().getInt("QNTY",0);

        String result = "text : "+ text +" q: "+ quantity;
        textView.setText(result);
    }
}