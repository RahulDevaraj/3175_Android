package com.example.finalprep2.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalprep2.R;
import com.example.finalprep2.database.DogDBClass;
import com.example.finalprep2.databinding.ActivityDogEditBinding;
import com.example.finalprep2.entities.DogDbEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DogEditActivity extends AppCompatActivity {

    DogDBClass database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDogEditBinding binding = ActivityDogEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        database = Room.databaseBuilder(getApplicationContext(),DogDBClass.class,"DogDB.db").build();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            try {
                DogDbEntity dogDbEntity = database.dogDao().getSelectedDogData(1);
                runOnUiThread(()->{
                    EditText editTextId = binding.editTextDogID;
                    EditText editTextName = binding.editTextDogName;
                    Button button = binding.button1;

                    editTextId.setText(dogDbEntity.getDogId()+"");
                    editTextId.setEnabled(false);
                    editTextName.setText(dogDbEntity.getDogName());
                    button.setOnClickListener((View view) ->{


                    executorService.execute(()->{
                        int i=database.dogDao().updateSelectedDog(editTextName.getText().toString(),dogDbEntity.getDogId());
                        runOnUiThread(()->{
                            Toast.makeText(this, "Edited Successfully "+editTextName.getText().toString(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(this,ListPlusDB.class));
                        });
                    });
                    });


                });

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        });


    }
}