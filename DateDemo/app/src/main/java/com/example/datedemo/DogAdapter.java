package com.example.datedemo;


import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datedemo.databinding.LayoutDogitemBinding;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogViewHolder> {

    List<Dog> AdapterDogData;
    OnItemClickListener onItemClickListener;

    public DogAdapter(List<Dog> adapterDogData, OnItemClickListener onItemClickListener) {
        AdapterDogData = adapterDogData;
        this.onItemClickListener = onItemClickListener;
    }

    public DogAdapter(List<Dog> adapterDogData) {
        AdapterDogData = adapterDogData;
    }

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutDogitemBinding binding = LayoutDogitemBinding.inflate(
                LayoutInflater.from(parent.getContext()),parent,false
        );

        DogViewHolder holder = new DogViewHolder(binding);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemCick(holder.getAdapterPosition());
            }
        });

//        holder.holderBinding.txtViewDOB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onItemClickListener.onItemCick();
//            }
//        });

        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull DogViewHolder holder, int position) {
        holder.holderBinding.txtViewId.setText(String.valueOf(AdapterDogData.get(position).getId()));
        holder.holderBinding.txtViewBreed.setText((AdapterDogData.get(position).getDogBreed()));
        holder.holderBinding.txtViewName.setText((AdapterDogData.get(position).getDogName()));
        holder.holderBinding.imgViewDogPic.setImageResource(AdapterDogData.get(position).getDogPicDrawable());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        holder.holderBinding.txtViewDOB.setText(formatter.format(AdapterDogData.get(position).getDob()));

    }

    @Override
    public int getItemCount() {
        return AdapterDogData.size();
    }

    public class DogViewHolder extends RecyclerView.ViewHolder {

        LayoutDogitemBinding holderBinding;

        public DogViewHolder(LayoutDogitemBinding binding) {

            super(binding.getRoot());
            holderBinding = binding; // vvimp
        }
    }

    public interface OnItemClickListener{
        void onItemCick(int index);
        //image click, txtviewClick..... can be implemented
    }


}
