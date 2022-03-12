package com.example.mid;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    boolean isPlay = false;
    MediaPlayer mediaPlayer = null;
    int pauseLength = 0;
    ArrayList<Integer> songs = new ArrayList<>(Arrays.asList(R.raw.drums));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonPlay);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isPlay && pauseLength==0)
                {
                    isPlay = true;
                    playSong();
                    button.setText("Pause");
                }
                else if(isPlay){
                    isPlay = false;
                    pauseSong();
                    button.setText("Resume");

                }
                else{
                    isPlay = true;
                    songResume();
                    button.setText("Pause");
                }


            }
        });


    }

    public void playSong(){
        mediaPlayer = MediaPlayer.create(MainActivity.this,songs.get(0));
        mediaPlayer.start();
    }

    public void pauseSong(){
        mediaPlayer.pause();
        pauseLength = mediaPlayer.getCurrentPosition();
    }

    public void songResume(){
        mediaPlayer.seekTo(pauseLength);
        mediaPlayer.start();
    }

}