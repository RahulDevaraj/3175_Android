package com.example.midsemexamprep;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setLogo(R.mipmap.ic_launcher_car_round);


        Button spinnerButton = findViewById(R.id.buttonSpinner);
        Button radioButton = findViewById(R.id.buttonRadio);
        Button adapterButton = findViewById(R.id.buttonArrayAdapter);
        Button buttonCustomAdapter1 = findViewById(R.id.buttonCustomAdapter1);
        Button buttonMusic = findViewById(R.id.buttonMusicPlayer);
        Button buttonGrid = findViewById(R.id.buttonGrid);

        spinnerButton.setOnClickListener((View view)-> {
        startActivity(new Intent(this,SpinnerActivity.class));
        });

        radioButton.setOnClickListener((View view)-> {
            startActivity(new Intent(this,RadioActivity.class));
        });

        adapterButton.setOnClickListener((View view)-> {
            startActivity(new Intent(this,DefaultArrayAdapter.class));
        });

        buttonCustomAdapter1.setOnClickListener((View view)-> {
            startActivity(new Intent(this,CustomAdapterDriver1.class));
        });

        buttonMusic.setOnClickListener((View view)-> {
            startActivity(new Intent(this,MusicPlayerDriver.class));
        });

        buttonGrid.setOnClickListener((View view)-> {
            startActivity(new Intent(this,GridActivity.class));
        });


    }
}