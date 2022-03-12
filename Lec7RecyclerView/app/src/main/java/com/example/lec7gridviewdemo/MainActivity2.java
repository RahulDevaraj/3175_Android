package com.example.lec7gridviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    List<GalleryImage> animalPicGallery = new ArrayList<>();
    Toast currentToast;
    int clickedItem = -1;

    private void addData(){
        animalPicGallery.add(new GalleryImage(101,"Gorilla",R.drawable.gorilla));
        animalPicGallery.add(new GalleryImage(102,"Panda",R.drawable.panda));
        animalPicGallery.add(new GalleryImage(103,"Eagle",R.drawable.eagle));
        animalPicGallery.add(new GalleryImage(104,"Panther",R.drawable.panther));
        animalPicGallery.add(new GalleryImage(105,"Elephant",R.drawable.elephant));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        addData();
        ImageView imageViewLarge2 = findViewById(R.id.imageViewLarge2);

        RecyclerView recyclerViewImages = findViewById(R.id.recyclerViewImages);

      //  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerViewImages.setLayoutManager(gridLayoutManager);

        //recyclerViewImages.setAdapter(new ImageRecyclerViewAdapter(animalPicGallery));

        ImageRecyclerViewAdapter myAdapter = new ImageRecyclerViewAdapter(animalPicGallery, new ImageRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int i) {
            imageViewLarge2.setImageResource(animalPicGallery.get(i).getImgPic());
            }
        });
        recyclerViewImages.setAdapter(myAdapter);
    }
}