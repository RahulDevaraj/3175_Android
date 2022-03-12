package com.example.midsemexamprep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class DefaultArrayAdapter extends AppCompatActivity {

    ArrayList<String> arrayList = new ArrayList<>
            (Arrays.asList("Item 1","Item 2","Item 3","Item 4"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_array_adapter);

        ListView listView = findViewById(R.id.listView1);
        TextView textView = findViewById(R.id.textViewDefaultArrayAdapter);

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(stringArrayAdapter);

        listView.setOnItemClickListener((AdapterView<?> adapterView, View view, int i, long l) -> {

            textView.setText(arrayList.get(i));
        });
    }
}