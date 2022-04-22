package com.example.finalprep2.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalprep2.R;
import com.example.finalprep2.database.DogDBClass;
import com.example.finalprep2.databinding.ActivityListPlusDbBinding;
import com.example.finalprep2.entities.DogDbEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ListPlusDB extends AppCompatActivity {

    List<DogDbEntity> dogDbEntityList;
    DogDBClass database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListPlusDbBinding binding = ActivityListPlusDbBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addData();

        database = Room
                .databaseBuilder(getApplicationContext(),DogDBClass.class,"DogDB.db").build();
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(()->{

try {
    database.dogDao().insertAllDogData(dogDbEntityList);
    List<DogDbEntity> list = database.dogDao().getAllDogData(0);
    runOnUiThread(()->{
        ListView listView = binding.listView;
        ArrayAdapter adapter = new ArrayAdapter<>(ListPlusDB.this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((AdapterView<?> adapterView, View view, int i, long l)-> {

            TextView textView = binding.textViewD;
            textView.setText(list.get(i).getDogId()+"");
        });
    });
}
catch (Exception e)
{
    e.printStackTrace();
}


        });

    }

    void addData(){
        dogDbEntityList = new ArrayList<>();
        dogDbEntityList.add(new DogDbEntity(1,"Dog 1"));
        dogDbEntityList.add(new DogDbEntity(2,"Dog 2"));
        dogDbEntityList.add(new DogDbEntity(3,"Dog 3"));
        dogDbEntityList.add(new DogDbEntity(4,"Dog 4"));
        dogDbEntityList.add(new DogDbEntity(5,"Dog 5"));
    }

}