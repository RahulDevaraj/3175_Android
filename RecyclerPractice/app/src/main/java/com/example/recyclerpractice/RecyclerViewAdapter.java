package com.example.recyclerpractice;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//2. Extend the class
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {
    List<DataClass> classList;
    OnItemClickListener onItemClickListener;


    public RecyclerViewAdapter(List<DataClass> classList) {
        this.classList = classList;
    }

    public RecyclerViewAdapter(List<DataClass> classList, OnItemClickListener onItemClickListener) {
        this.classList = classList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_constraint,viewGroup,false);

        CustomViewHolder customViewHolder = new CustomViewHolder(view);
        customViewHolder.imageView=view.findViewById(R.id.imageView);
        customViewHolder.textView = view.findViewById(R.id.textView);

        customViewHolder.imageView.setOnClickListener((View newView)-> {
                customViewHolder.textView.setBackgroundColor(Color.LTGRAY);
                onItemClickListener.onItemClick(customViewHolder.getAdapterPosition());//imp
                    });

        customViewHolder.textView.setOnClickListener((View newView)-> {
                notifyDataSetChanged();
                onItemClickListener.onItemClick(-1);//imp
        });

         return customViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int i) {
        holder.textView.setText(classList.get(i).getText());
        holder.imageView.setImageResource(classList.get(i).getImage());
        holder.textView.setBackgroundColor(Color.WHITE);

    }

    @Override
    public int getItemCount() {
        return classList.size();
    }

    //1.Create custom view Holder
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    interface OnItemClickListener{
        void onItemClick(int i);
    }

}
