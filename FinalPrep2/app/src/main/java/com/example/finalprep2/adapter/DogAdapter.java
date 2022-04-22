package com.example.finalprep2.adapter;

import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprep2.Dog;
import com.example.finalprep2.databinding.LayoutDogCardBinding;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogHolder> {
    List<Dog> dogList;
    OnItemClickListener onItemClickListener;
    int currentIndex = -1;

    public DogAdapter(List<Dog> dogList, OnItemClickListener onItemClickListener) {
        this.dogList = dogList;
        this.onItemClickListener = onItemClickListener;
    }

    public DogAdapter(List<Dog> dogList) {
        this.dogList = dogList;
    }

    @NonNull
    @Override
    public DogHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutDogCardBinding binding = LayoutDogCardBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        DogHolder holder = new DogHolder(binding);

        holder.holderBinding.imageViewDogPic.setOnClickListener((View view)-> {
            currentIndex = holder.getAdapterPosition();
            notifyDataSetChanged();
        });

        holder.holderBinding.textViewDogName.setOnClickListener((View view)-> {

            onItemClickListener.OnNameClick(holder.getAdapterPosition());
        });

        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull DogHolder holder, int position) {
        holder.holderBinding.textViewDogId.setText(String.valueOf(dogList.get(position).getId()));
        holder.holderBinding.textViewDogName.setText(dogList.get(position).getDogName());
        holder.holderBinding.textViewDogBreed.setText(dogList.get(position).getDogBreed());
        holder.holderBinding.imageViewDogPic.setImageResource(dogList.get(position).getDogPic());

        LocalDate localDate = dogList.get(position).getDob();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yy");
        String dob = formatter.format(localDate);

        holder.holderBinding.textViewDOB.setText(dob);
        if(currentIndex==position)
            holder.itemView.setBackgroundColor(Color.LTGRAY);
        else
            holder.itemView.setBackgroundColor(Color.WHITE);





    }

    @Override
    public int getItemCount() {
        return dogList.size();
    }


    public class DogHolder extends RecyclerView.ViewHolder{
        LayoutDogCardBinding holderBinding;

        public DogHolder(LayoutDogCardBinding binding) {
            super(binding.getRoot());
            holderBinding = binding;
        }
    }

    public interface OnItemClickListener{
        void OnNameClick(int index);
    }
}
