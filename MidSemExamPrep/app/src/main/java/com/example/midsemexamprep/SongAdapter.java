package com.example.midsemexamprep;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class SongAdapter extends BaseAdapter {

    ArrayList<String> songNames;
    int index = -1;
    boolean isPlay = false;

    public boolean getIsPlay() {
        return isPlay;
    }

    public void setPlay(boolean play) {
        isPlay = play;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
        notifyDataSetChanged();
    }

    public SongAdapter(ArrayList<String> songNames) {
        this.songNames = songNames;

    }

    @Override
    public int getCount() {
        return songNames.size();
    }

    @Override
    public Object getItem(int i) {
        return songNames.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       if(view == null)
       {
           view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_songs,viewGroup,false);
       }

        TextView textView = view.findViewById(R.id.textViewSongName);
        ImageView imageView = view.findViewById(R.id.imageViewSongPic);

        textView.setText(songNames.get(i));
        imageView.setImageResource(R.drawable.carwash);


       return view;
    }
}
