package com.example.finalprep1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.finalprep1.R;
import com.example.finalprep1.databinding.ActivityNextBinding;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNextBinding binding = ActivityNextBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Spinner spinner = binding.spinner;
        TextView textView = binding.textViewResult;
        RadioGroup radioGroup = binding.radioGroup;
        Button button = binding.buttonClick;

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText(spinner.getSelectedItem().toString()+"\n"+spinner.getSelectedItemPosition());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        binding.radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Button 1");
            }
        });

        button.setOnClickListener((View view)-> {
            if(radioGroup.getCheckedRadioButtonId() == R.id.radioButton1)
                textView.setText("Button 1");
            else
            if(radioGroup.getCheckedRadioButtonId() == R.id.radioButton2)
                textView.setText("Button 2");

        });
    }
}