package com.example.midsemexamprep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomAdapterDriver1 extends AppCompatActivity {

    ArrayList<String> arrayList1 = new ArrayList<>
            (Arrays.asList("A1","A2","A3","A4"));
    ArrayList<String> arrayList2 = new ArrayList<>
            (Arrays.asList("B1","B2","B3","B4"));
    ArrayList<String> arrayList3 = new ArrayList<>
            (Arrays.asList("C1","C2","C3","C4"));

    Toast currentToast = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter_driver1);

        ListView listView = findViewById(R.id.listViewCustom1);
        CustomAdapter1 customAdapter1 = new CustomAdapter1(arrayList1,arrayList2,arrayList3);
        listView.setAdapter(customAdapter1);

        listView.setOnItemClickListener((AdapterView<?> adapterView, View view, int i, long l)-> {
            if(currentToast !=null)
                currentToast.cancel();

            currentToast = Toast.makeText(this, ""+i, Toast.LENGTH_SHORT);
            currentToast.show();

            switch (i){
                case 0:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com")));
                    break;
                case 1:
                    startActivity(new Intent(this,Webdemo2Activity.class));
                    break;
            }
        });

    }
}