package com.example.midsemexamprep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        setTitle("In Spinner Page");

        Spinner spinner = findViewById(R.id.spinner);
        EditText editTextQuantity = findViewById(R.id.editTextQuantity);
        Button buttonInSpinner = findViewById(R.id.buttonInSpinnerPage);

        buttonInSpinner.setOnClickListener((View view) -> {
        if(spinner.getSelectedItemPosition() == -1)
        {
            Toast.makeText(this, "Please Select Spinner", Toast.LENGTH_SHORT).show();
        }
        else if(editTextQuantity.getText().toString().isEmpty()){
            Toast.makeText(this, "Please Enter Quantity", Toast.LENGTH_SHORT).show();
        }
        else{

            try {
                String text = spinner.getSelectedItem().toString();
                int quantity = Integer.parseInt(editTextQuantity.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putString("TEXT",text);
                bundle.putInt("QNTY",quantity);

                Intent myIntent = new Intent(SpinnerActivity.this,SpinnerResult.class);
                myIntent.putExtras(bundle);

                startActivity(myIntent);

            }
            catch (Exception e){
                e.printStackTrace();
                Toast.makeText(this, "Enter Number", Toast.LENGTH_SHORT).show();
            }
        }

        });

    }
}