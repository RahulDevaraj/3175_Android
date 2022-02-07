package com.example.jan4practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Segway");

        button1 = findViewById(R.id.button);


        button1.setOnClickListener((View view)->{
            startActivity(new Intent(MainActivity.this,MainActivity2.class));
        });
    }
}