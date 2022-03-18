package com.example.lec8dbdemo.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lec8dbdemo.R;
import com.example.lec8dbdemo.databinding.LayoutStudentBinding;
import com.example.lec8dbdemo.model.Student;

import java.util.List;

public class StudentAdapter extends BaseAdapter {
    List<Student> allStudents;

    public StudentAdapter(List<Student> allStudents) {
        this.allStudents = allStudents;
    }

    @Override
    public int getCount() {
        return allStudents.size()+1;
    } // Header is not read.. so adding it manually

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
//        if (view == null) {
//            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_student,viewGroup,false);
//        }
        LayoutStudentBinding binding = LayoutStudentBinding.inflate
                (LayoutInflater.from(viewGroup.getContext()),viewGroup,false);
        TextView textViewStudentID = binding.textViewStudentID;
        TextView textViewStudentName = binding.textViewStudentName;
        TextView textViewStudentDept = binding.textViewStudentDept;

        if(i==0)
        {
            textViewStudentID.setText("ID");
            textViewStudentName.setText("Name");
            textViewStudentDept.setText("Dept");
            textViewStudentID.setBackgroundColor(Color.RED);
            textViewStudentName.setBackgroundColor(Color.RED);
            textViewStudentDept.setBackgroundColor(Color.RED);
        }
        else{
            textViewStudentID.setText(allStudents.get(i-1).getStudentId());
            textViewStudentName.setText(allStudents.get(i-1).getStudentName());
            textViewStudentDept.setText(allStudents.get(i-1).getStudentDept());
            textViewStudentID.setBackgroundColor(Color.WHITE);
            textViewStudentName.setBackgroundColor(Color.WHITE);
            textViewStudentDept.setBackgroundColor(Color.WHITE);
        }
        return binding.getRoot();
    }
}
