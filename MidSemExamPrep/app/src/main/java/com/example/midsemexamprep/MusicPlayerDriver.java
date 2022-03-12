package com.example.midsemexamprep;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MusicPlayerDriver extends AppCompatActivity {

    ArrayList<String> songNames = new ArrayList<>(Arrays.asList("Song1","Song2","Song3"));
    ArrayList<Integer> rawSongs = new ArrayList<>(Arrays.asList(R.raw.bagpipes,R.raw.drums,R.raw.ukulele));
    MediaPlayer mediaPlayer = null;
    int length;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player_driver);

        ListView listView = findViewById(R.id.listViewSongs);

        SongAdapter songAdapter = new SongAdapter(songNames);
        listView.setAdapter(songAdapter);

        listView.setOnItemClickListener((AdapterView<?> adapterView, View view, int i, long l) -> {

            if(mediaPlayer!=null && mediaPlayer.isPlaying() )
            {
                mediaPlayer.pause();
                length = mediaPlayer.getCurrentPosition();


            }
            if(songAdapter.getIndex() == i)
                songAdapter.setIndex(-1);

            else
            {

                songAdapter.setIndex(i);
                mediaPlayer = MediaPlayer.create(MusicPlayerDriver.this,rawSongs.get(i));
                mediaPlayer.start();
            }

        });
    }


}