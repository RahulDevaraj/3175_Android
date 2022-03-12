package com.example.midsemexamprep;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridClass extends BaseAdapter {
    ArrayList<Integer> arrayListPic;

    public GridClass(ArrayList<Integer> arrayListPic) {
        this.arrayListPic = arrayListPic;
    }

    @Override
    public int getCount() {
        return arrayListPic.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListPic.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {

            LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
            view = layoutInflater.inflate(R.layout.layout_grid,viewGroup,false);

        }

        ImageView imageView = view.findViewById(R.id.imageViewGrid);
        imageView.setImageResource(arrayListPic.get(i));
        imageView.setBackgroundColor(Color.LTGRAY);

        TextView textView = view.findViewById(R.id.textViewGRid);
        textView.setText(""+i);

        return view;
    }
}
