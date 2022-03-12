package com.example.midsemexamprep;

import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomAdapter1 extends BaseAdapter {
    ArrayList<String> arrayList1;
    ArrayList<String> arrayList2;
    ArrayList<String> arrayList3;

    public CustomAdapter1(ArrayList<String> arrayList1, ArrayList<String> arrayList2, ArrayList<String> arrayList3) {
        this.arrayList1 = arrayList1;
        this.arrayList2 = arrayList2;
        this.arrayList3 = arrayList3;
    }

    @Override
    public int getCount() {
        return arrayList1.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList1.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            view = LayoutInflater.from(viewGroup.getContext()).
                    inflate(R.layout.layout_custom1,viewGroup,false);
        }

        TextView textViewCustom1,textViewCustom2,textViewCustom3;
        textViewCustom1 = view.findViewById(R.id.textViewCustom1);
        textViewCustom2 = view.findViewById(R.id.textViewCustom2);
        textViewCustom3 = view.findViewById(R.id.textViewCustom3);

        textViewCustom1.setText(arrayList1.get(i));
        textViewCustom2.setText(arrayList2.get(i));
        textViewCustom3.setText(arrayList3.get(i));

        textViewCustom2.setGravity(Gravity.CENTER);

        Drawable drawable = ResourcesCompat.getDrawable(viewGroup.getResources(),R.drawable.carwash,viewGroup.getContext().getTheme());
        drawable.setBounds(0,0,100,100);

        textViewCustom2.setCompoundDrawables(null,null,drawable,null);
        return view;
    }
}
