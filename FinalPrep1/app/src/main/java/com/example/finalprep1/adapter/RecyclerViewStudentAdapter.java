package com.example.finalprep1.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprep1.databinding.LayoutStudentRowBinding;
import com.example.finalprep1.entity.Student;

import java.util.List;

public class RecyclerViewStudentAdapter extends RecyclerView.Adapter<RecyclerViewStudentAdapter.StudentHolder>{

    List<Student> students;
    int currentIndex = -1;
    OnItemClickListener onItemClickListener;

    public RecyclerViewStudentAdapter(List<Student> students, OnItemClickListener onItemClickListener) {
        this.students = students;
        this.onItemClickListener = onItemClickListener;
    }

    public RecyclerViewStudentAdapter(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutStudentRowBinding binding = LayoutStudentRowBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,false);

        StudentHolder holder = new StudentHolder(binding);

//        holder.itemView.setOnClickListener((View view)-> {
//            onItemClickListener.onItemClick(holder.getAdapterPosition());
//            currentIndex = holder.getAdapterPosition();
//            notifyDataSetChanged();
//        });

        holder.holderBinding.textViewId.setOnClickListener((View view)-> {
            onItemClickListener.onItemClick(holder.getAdapterPosition());
            notifyDataSetChanged();
        });

        holder.holderBinding.textViewName.setOnClickListener((View view)-> {
            onItemClickListener.onItemClick2(holder.getAdapterPosition());
            currentIndex = holder.getAdapterPosition();
            notifyDataSetChanged();
        });



        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {
        holder.holderBinding.textViewId.setText(students.get(position).getId());
        holder.holderBinding.textViewName.setText(students.get(position).getName());
        holder.holderBinding.textViewCourse.setText(students.get(position).getCourse());
        if(currentIndex==position)
            holder.itemView.setBackgroundColor(Color.LTGRAY);
        else
            holder.itemView.setBackgroundColor((Color.WHITE));

    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class StudentHolder extends RecyclerView.ViewHolder {
        LayoutStudentRowBinding holderBinding;
        public StudentHolder(LayoutStudentRowBinding binding) {
            super(binding.getRoot());
            holderBinding = binding;
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int index);
        void onItemClick2(int index);
    }
}
