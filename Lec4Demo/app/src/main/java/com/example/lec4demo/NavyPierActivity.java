package com.example.lec4demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

public class NavyPierActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navy_pier);

        TextView textViewNavyPier = findViewById(R.id.textNavyPierHours);
        textViewNavyPier.setText("Click for Info "+
                "\nhttps://navypier.org/plan-your-visit/hours-and-admission/");

        Linkify.addLinks(textViewNavyPier,Linkify.WEB_URLS);
    }
}