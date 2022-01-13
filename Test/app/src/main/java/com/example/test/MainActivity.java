package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonMain;

    final String TAG = "App Testing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"Started Successfully");

        buttonMain = findViewById(R.id.buttonMain);

        buttonMain.setOnClickListener((View view) ->{
            startActivity(new Intent(this,Page2.class));
                });

    }
}