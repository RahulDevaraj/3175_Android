package com.example.lec7gridviewdemo;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageRecyclerViewAdapter extends RecyclerView.Adapter<ImageRecyclerViewAdapter.ImageViewHolder> {

    //create data
    List<GalleryImage> animalList;
    OnItemClickListener onItemClickListener;
    int currentIndex = -1;

    public ImageRecyclerViewAdapter(List<GalleryImage> animalList) {
        this.animalList = animalList;
    }

    public ImageRecyclerViewAdapter(List<GalleryImage> animalList, OnItemClickListener onItemClickListener) {
        this.animalList = animalList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ImageView imageViewItem = new ImageView(viewGroup.getContext());
        imageViewItem.setLayoutParams(new ViewGroup.LayoutParams(GridView.AUTO_FIT,150));

        //another inflate external obj & use findviewbyid

        //if external layout, view obj will be used to create view holder
        ImageViewHolder imageViewHolder = new ImageViewHolder(imageViewItem);
        //we can findviewbyid in external layout
        imageViewHolder.itemImageView = imageViewItem;//eg. imageViewHolder.itemImageView = view.findViewbyid(R.id.___);

        imageViewHolder.itemImageView.setOnClickListener((View view)-> {
            currentIndex = imageViewHolder.getAdapterPosition();
            onItemClickListener.onItemClick(imageViewHolder.getAdapterPosition());
            notifyDataSetChanged();

        });


        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder,  int i) {
        holder.itemImageView.setImageResource(animalList.get(i).getImgPic());
        //like currentplaying index logic

//        holder.itemImageView.setOnClickListener((View view)-> {
//            currentIndex = holder.getAdapterPosition();
//            notifyDataSetChanged();
//        });
        if(currentIndex == i){
            holder.itemImageView.setBackgroundColor(Color.LTGRAY);
        }
        else
            holder.itemImageView.setBackgroundColor(Color.WHITE);
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }


    //add cons

    //implement

    //create custom view holder
    public class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImageView;
        //other views
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    interface OnItemClickListener{
        void onItemClick(int i);
    }


}
