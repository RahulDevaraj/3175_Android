package com.example.lec1demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnShowRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowRecipe = findViewById(R.id.buttonShowRecipe); //Only called after setContentView

        //startActivity(new Intent(this,RecipeActivity.class));
        btnShowRecipe.setOnClickListener((View view) -> {
            //Start the Activity
            startActivity(new Intent(MainActivity.this,RecipeActivity.class));

            });

    }
}