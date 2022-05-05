package com.example.rahuld_3175final;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahuld_3175final.databinding.LayoutCourseitemBinding;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CourseViewHolder> {
    List<Course> courseList;
    OnItemClickListener onItemClickListener;

    public RecyclerViewAdapter(List<Course> courseList, OnItemClickListener onItemClickListener) {
        this.courseList = courseList;
        this.onItemClickListener = onItemClickListener;
    }

    public RecyclerViewAdapter(List<Course> courseList) {
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutCourseitemBinding binding = LayoutCourseitemBinding.inflate(
               LayoutInflater.from(parent.getContext()),parent,false
       );

       CourseViewHolder holder = new CourseViewHolder(binding);

       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               onItemClickListener.onItemClick(holder.getAdapterPosition());
           }
       });

       return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {


    holder.holderBinding.txtViewCoursePrice.setText(String.format("$ %.2f",courseList.get(position).getCoursePrice()));

   if(courseList.get(position).getCourseDiscount() == 1)
        holder.holderBinding.imgViewDiscount.setImageResource(R.drawable.discount);

        LocalDate localDate = courseList.get(position).getCourseDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        String dateString =  formatter.format(localDate);

        holder.holderBinding.txtViewCourseNameAndDate.setText(courseList.get(position).courseName+"\n"+
                dateString);




        holder.holderBinding.imgViewCourse.setImageResource(courseList.get(position).getCourseDrawable());


    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {
        LayoutCourseitemBinding holderBinding;


        public CourseViewHolder(LayoutCourseitemBinding binding) {
            super(binding.getRoot());
            holderBinding = binding;
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int index);
    }
}
