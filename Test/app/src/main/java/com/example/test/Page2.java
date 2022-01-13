package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Page2 extends AppCompatActivity {

    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        buttonBack = findViewById(R.id.buttonBack);

        buttonBack.setOnClickListener((View view)->{
        startActivity(new Intent(this,MainActivity.class));
        });
    }


}