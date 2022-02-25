package com.example.lec7gridviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<GalleryImage> animalPicGallery = new ArrayList<>();
    Toast currentToast;
    int clickedItem = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addData();

        GridView gridViewImages = findViewById(R.id.gridViewImages);
        ImageView imageViewLarge = findViewById(R.id.imageViewLarge);
        imageViewLarge.setImageResource(0);//image set to null

        ImageAdapter myImageAdapter = new ImageAdapter(animalPicGallery);
        gridViewImages.setAdapter(myImageAdapter);
        gridViewImages.setNumColumns(3);
        gridViewImages.setHorizontalSpacing(8);
        gridViewImages.setVerticalSpacing(8);

        gridViewImages.setOnItemClickListener((AdapterView<?> adapterView, View view, int i, long l) ->{

            clickedItem = i;
            imageViewLarge.setImageResource(animalPicGallery.get(i).getImgPic());

            if(currentToast !=null){
                currentToast.cancel();
            }
            currentToast = Toast.makeText(MainActivity.this,
                    "Species : "+animalPicGallery.get(i).getImgName(),
                    Toast.LENGTH_SHORT);
            currentToast.show();
        });

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        clickedItem = sharedPreferences.getInt("IMGIND",-1);
        if(clickedItem != -1){
            imageViewLarge.setImageResource(animalPicGallery.get(clickedItem).imgPic);
        }
        else
        {
            imageViewLarge.setImageResource(0);
        }

    }

    private void addData(){
        animalPicGallery.add(new GalleryImage(101,"Gorilla",R.drawable.gorilla));
        animalPicGallery.add(new GalleryImage(102,"Panda",R.drawable.panda));
        animalPicGallery.add(new GalleryImage(103,"Eagle",R.drawable.eagle));
        animalPicGallery.add(new GalleryImage(104,"Panther",R.drawable.panther));
        animalPicGallery.add(new GalleryImage(105,"Elephant",R.drawable.elephant));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("IMGIND",clickedItem);
        editor.commit();//imp
    }

}