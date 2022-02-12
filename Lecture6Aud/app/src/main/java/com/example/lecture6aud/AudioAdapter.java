package com.example.lecture6aud;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AudioAdapter extends BaseAdapter {

    List<String> songNames;
    List<Integer> songPics;
    int currentPlayIndex =-1;

    public int getCurrentPlayIndex() {
        return currentPlayIndex;
    }

    public void setCurrentPlayIndex(int currentPlayIndex) {
        this.currentPlayIndex = currentPlayIndex;
        notifyDataSetChanged(); //adapter repopulates data with getView
    }

    public AudioAdapter(List<String> songNames, List<Integer> songPics) {
        this.songNames = songNames;
        this.songPics = songPics;
    }

    @Override
    public int getCount() {
        return songNames.size();
    }

    @Override
    public String getItem(int i) {
        return songNames.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layout_song,viewGroup,false);
        }
        TextView textViewSong = view.findViewById(R.id.textViewSongItem);
        ImageView imageViewSong = view.findViewById(R.id.imageViewSongItem);
        ImageView imageViewPlayStop = view.findViewById(R.id.imageViewPlayStop);

        textViewSong.setText(songNames.get(i));
        imageViewSong.setImageResource(songPics.get(i));
        if(i==currentPlayIndex){
            imageViewPlayStop.setImageResource(R.drawable.stop);
        }
        else{
            imageViewPlayStop.setImageResource(R.drawable.play);
        }

        return view;

    }
}
