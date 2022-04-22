package com.example.finalprep2.adapter;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.finalprep2.Dog;
import com.example.finalprep2.R;
import com.example.finalprep2.databinding.LayoutDogListviewBinding;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DogListAdapter extends BaseAdapter {
    List<Dog> dogList;

    public DogListAdapter(List<Dog> dogList) {
        this.dogList = dogList;
    }

    @Override
    public int getCount() {
        return dogList.size();
    }

    @Override
    public Object getItem(int i) {
        return dogList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view==null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_dog_listview
            ,viewGroup,false);
        }

        ImageView imageView = view.findViewById(R.id.imageViewDogPic2);
        TextView textViewDogName = view.findViewById(R.id.textViewDogName2);
        TextView textViewDogID = view.findViewById(R.id.textViewDogId2);
        TextView textViewDogBreed = view.findViewById(R.id.textViewDogBreed2);
        TextView textViewDob = view.findViewById(R.id.textViewDogDob2);

        imageView.setImageResource(dogList.get(i).getDogPic());
        textViewDogID.setText(dogList.get(i).getId()+"");
        textViewDogBreed.setText(dogList.get(i).getDogBreed());
        textViewDogName.setText(dogList.get(i).getDogName());

        LocalDate localDate = dogList.get(i).getDob();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yy");
        String dob = formatter.format(localDate);

        textViewDob.setText(dob);




        return view;
    }
}
