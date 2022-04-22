package com.example.finalprep2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.finalprep2.R;
import com.example.finalprep2.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMain3Binding binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView textViewResult = binding.textViewResult3;

        String dogName  = getIntent().getExtras().getString("DOGNAME",null);
        int dogId = getIntent().getExtras().getInt("DOGID",0);

        textViewResult.setText(dogId+" "+dogName);
    }
}