package com.example.mid;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GridClass extends BaseAdapter {
    ArrayList<String> arrayList;

    public GridClass(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_grid,viewGroup,false);
            Log.d("TAG","reached inflate");
        }
        TextView textView = view.findViewById(R.id.textView1);
        textView.setText(""+(i+1));

        return view;
    }
}
