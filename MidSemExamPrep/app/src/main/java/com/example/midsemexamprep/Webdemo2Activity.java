package com.example.midsemexamprep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

public class Webdemo2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webdemo2);

        TextView textView = findViewById(R.id.textViewWebDemo);

        textView.setText("Click Here :"+"" +
                "\nhttps://www.youtube.com/");

        Linkify.addLinks(textView,Linkify.WEB_URLS);
    }
}