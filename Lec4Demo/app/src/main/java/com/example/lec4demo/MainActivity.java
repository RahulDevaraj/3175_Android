package com.example.lec4demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     ListView listViewSites;
     List<String> ChicagoSiteNames = new ArrayList<>
             (Arrays.asList("Magnificient Mile","Navy Pier","Art Institute"));
     List<Integer> ChicagoSitePics = new ArrayList<>
             (Arrays.asList(R.drawable.magmile,R.drawable.pier,R.drawable.artinst));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewSites = findViewById(R.id.listViewSites);
        ArrayAdapter<String> sitesArrAdapter = new ArrayAdapter<>
                (MainActivity.this, android.R.layout.simple_list_item_1,ChicagoSiteNames);
        listViewSites.setAdapter(sitesArrAdapter);
    }
}