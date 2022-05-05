package com.example.rahuld_3175final;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rahuld_3175final.databinding.LayoutPurchaseitemBinding;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    List<Course> courseList;

    public ListViewAdapter(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public int getCount() {
        return courseList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
//        if(view == null){
//            LayoutInflater layoutInflater = LayoutInflater.from(
//                    parent.getContext()
//            );
//            view = layoutInflater.inflate(R.layout.layout_purchaseitem,parent,false);
//        }
        LayoutPurchaseitemBinding binding = LayoutPurchaseitemBinding.inflate(
                LayoutInflater.from(parent.getContext()),parent,false
        );

        TextView courseName = binding.txtViewPurchasedCourseName;
                //view.findViewById(R.id.txtViewPurchasedCourseName);
        TextView coursePrice = binding.txtViewPurchasedCoursePrice;
               // view.findViewById(R.id.txtViewPurchasedCoursePrice);
        ImageView image = binding.imgViewPurchasedDiscount;
                //view.findViewById(R.id.imgViewPurchasedDiscount);
        TextView num = binding.txtviewPurchasedNumSessions;
                //view.findViewById(R.id.txtviewPurchasedNumSessions);
        TextView total = binding.txtViewPurchasedSubTotal;
                //view.findViewById(R.id.txtViewPurchasedSubTotal);


        courseName.setText(courseList.get(position).getCourseName());
        coursePrice.setText("$ "+courseList.get(position).getCoursePrice());

        double tot = courseList.get(position).getCoursePrice() * courseList.get(position).getNumberOfSessions();


        if(courseList.get(position).getCourseDiscount() == 1){
            image.setImageResource(R.drawable.discount);
            tot = tot - .1*tot;
        }


        num.setText(""+courseList.get(position).getNumberOfSessions());

        total.setText(String.format("$ %.2f",tot));




        return binding.getRoot();
    }
}
