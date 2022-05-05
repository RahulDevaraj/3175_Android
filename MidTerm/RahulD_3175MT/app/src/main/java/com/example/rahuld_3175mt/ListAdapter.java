package com.example.rahuld_3175mt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListAdapter extends BaseAdapter {
    ArrayList<String> arrayListCampTimes;

    ArrayList<Integer> arrayListCampTimesPics;

    public ListAdapter(ArrayList<String> arrayListCampTimes, ArrayList<Integer> arrayListCampTimesPics) {
        this.arrayListCampTimes = arrayListCampTimes;
        this.arrayListCampTimesPics = arrayListCampTimesPics;
    }

    @Override
    public int getCount() {
        return arrayListCampTimes.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListCampTimes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       if(view == null){
           view = LayoutInflater.from(viewGroup.getContext()).
                   inflate(R.layout.layout_times,viewGroup,false);
       }

        TextView textView = view.findViewById(R.id.textViewTime);
        ImageView imageView = view.findViewById(R.id.imageViewTime);

        textView.setText(arrayListCampTimes.get(i));
        imageView.setImageResource(arrayListCampTimesPics.get(i));

       return  view;
    }
}
