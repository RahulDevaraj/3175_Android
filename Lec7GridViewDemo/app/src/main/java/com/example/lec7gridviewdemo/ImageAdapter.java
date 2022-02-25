package com.example.lec7gridviewdemo;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends BaseAdapter {
    List<GalleryImage> imageList;

    public ImageAdapter(List<GalleryImage> imageList) {
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public GalleryImage getItem(int i) {
        return imageList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return imageList.get(i).getImgId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            ImageView imageViewItem = new ImageView(viewGroup.getContext());
           // imageViewItem.setLayoutParams(new ViewGroup.LayoutParams(120,120));
            imageViewItem.setLayoutParams(new ViewGroup.LayoutParams(GridView.AUTO_FIT,150));
            imageViewItem.setImageResource(imageList.get(i).getImgPic());
            imageViewItem.setBackgroundColor(Color.LTGRAY);
            view = imageViewItem;
        }
        return view;
    }
}
