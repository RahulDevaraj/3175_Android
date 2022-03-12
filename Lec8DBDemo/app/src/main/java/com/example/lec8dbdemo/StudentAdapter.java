package com.example.lec8dbdemo;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends BaseAdapter {
    List<Student> allStudents;

    public StudentAdapter(List<Student> allStudents) {
        this.allStudents = allStudents;
    }

    @Override
    public int getCount() {
        return allStudents.size();
    }

    @Override
    public Object getItem(int i) {
        return allStudents.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_student,viewGroup,false);
        }

        if(i==0)
            view.setBackgroundColor(Color.RED);


        TextView textViewStudentID = view.findViewById(R.id.textViewStudentID);
        TextView textViewStudentName = view.findViewById(R.id.textViewStudentName);
        TextView textViewStudentDept = view.findViewById(R.id.textViewStudentDept);


        textViewStudentID.setText(allStudents.get(i).getStudentId());
        textViewStudentName.setText(allStudents.get(i).getStudentName());
        textViewStudentDept.setText(allStudents.get(i).getStudentDept());

        return view;
    }
}
