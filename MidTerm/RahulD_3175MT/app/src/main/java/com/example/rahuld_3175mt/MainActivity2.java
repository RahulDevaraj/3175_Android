package com.example.rahuld_3175mt;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity {

        ArrayList<Integer> activityPics = new ArrayList<>(
            Arrays.asList(R.drawable.soccer,R.drawable.theatre,R.drawable.karate));
        ArrayList<Double> activityCosts = new ArrayList<>(
            Arrays.asList(165.99,179.99,189.99));

        ArrayList<Integer> listSongs = new ArrayList<>
                (Arrays.asList(R.raw.soccer,R.raw.theatre,R.raw.karate));
        MediaPlayer mediaPlayer=null;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        try {
            String parentName = getIntent().getExtras().getString("PARENT",null);
            String campTime = getIntent().getExtras().getString("TIME",null);
            String outputString = "Parent Name : "+parentName+
                    "\n Camp Time : "+campTime;

            TextView textViewTitle = findViewById(R.id.textViewDisplay);
            textViewTitle.setText(outputString);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        Spinner spinnerCamps = findViewById(R.id.spinnerCamps);

        spinnerCamps.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> AdapterViewrent, View view, int i, long l) {
                index = spinnerCamps.getSelectedItemPosition();
                ImageView imageViewChosenCamp = findViewById(R.id.imageViewChosenCamp);
                imageViewChosenCamp.setImageResource(activityPics.get(i));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        EditText editTextNumKids = findViewById(R.id.editTextNumKids);
        Button buttonBookCamp = findViewById(R.id.buttonBookCamp);
        RadioGroup radioGroupFoodNeeded = findViewById(R.id.radioGroupFoodNeeded);
        buttonBookCamp.setOnClickListener((View view) ->{
            int numberOfKids;
            if(editTextNumKids.getText().toString().isEmpty()){
                Toast.makeText(this, "Number of Kids Cannot be Empty", Toast.LENGTH_SHORT).show();
            }
            else{
                try{
                    numberOfKids = Integer.parseInt(editTextNumKids.getText().toString());
                    if(numberOfKids<=0){
                        Toast.makeText(this, "Number of kids must be more than 0", Toast.LENGTH_SHORT).show();
                    }
                    else{

                        if(radioGroupFoodNeeded.getCheckedRadioButtonId() == -1){
                            Toast.makeText(this,
                                    "Please Select if u want or not want food for your Kids", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            //Display All
                            DecimalFormat decimalFormat = new DecimalFormat("$#.##");
                            String campName = spinnerCamps.getSelectedItem().toString();
                            Double costPerKid = activityCosts.get(spinnerCamps.getSelectedItemPosition());
                            //numberOfKids
                            Double campTotalWithoutFood = costPerKid * numberOfKids;
                            boolean isFood = false;
                            if(radioGroupFoodNeeded.getCheckedRadioButtonId() == R.id.radioButtonFood)
                                isFood = true;
                            Double foodCost;
                            if(isFood)
                            foodCost = 29.99*numberOfKids;
                            else
                                foodCost = 0.0;
                            Double grandTotal = campTotalWithoutFood + foodCost;

                            String finalOutput = "Camp Name : "+campName+
                                    "\n Camp base cost per Kid :"+decimalFormat.format(costPerKid)+
                                    "\n Number Of Kids :"+numberOfKids+
                                    "\n Camp Total (exld Food) : "+decimalFormat.format(campTotalWithoutFood)+
                                    "\n Food Cost : "+decimalFormat.format(foodCost)+
                                    "\n Grand Total : "+decimalFormat.format(grandTotal);

                            TextView textViewResults = findViewById(R.id.textViewResults);
                            textViewResults.setText(finalOutput);

                            if(mediaPlayer !=null && mediaPlayer.isPlaying())
                                mediaPlayer.stop();

                            mediaPlayer = MediaPlayer.create(this,listSongs.get(index));
                            mediaPlayer.start();



                        }

                    }

                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(this, "Invalid Input!! Please enter an Integer > 0", Toast.LENGTH_SHORT).show();

                }

            }



        });




    }
}