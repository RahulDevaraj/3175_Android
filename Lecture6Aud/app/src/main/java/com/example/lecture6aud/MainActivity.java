package com.example.lecture6aud;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> songNames = new ArrayList<>
            (Arrays.asList("Bag Pipes","Ukelele","Drums"));
    List<Integer> songPics =new ArrayList<>
            (Arrays.asList(R.drawable.bagpipes,R.drawable.ukulele,R.drawable.drums));
    List<Integer> songRaw = new ArrayList<>(Arrays.asList(R.raw.bagpipes,R.raw.ukulele,R.raw.drums));

    MediaPlayer mPlayer=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewSongs = findViewById(R.id.listViewSongs);
        AudioAdapter myAudioAdapter = new AudioAdapter(songNames,songPics);
        listViewSongs.setAdapter(myAudioAdapter);

        listViewSongs.setOnItemClickListener(
                (AdapterView<?> adapterView, View view, int i, long l) -> {
                    if(mPlayer!=null && mPlayer.isPlaying())
                        mPlayer.stop();

                    if(myAudioAdapter.getCurrentPlayIndex() == i){
                        myAudioAdapter.setCurrentPlayIndex(-1);
                    }
                    else{
                        myAudioAdapter.setCurrentPlayIndex(i);
                        mPlayer = MediaPlayer.create(MainActivity.this,songRaw.get(i));
                        mPlayer.start();

                        mPlayer.setOnCompletionListener((MediaPlayer mediaPlayer)-> {
                            Log.d("inPlay","inside looping");
                            try{
                                //mPlayer.prepare();

                                myAudioAdapter.setCurrentPlayIndex((myAudioAdapter.getCurrentPlayIndex()+1)%songRaw.size());
                                mPlayer = mediaPlayer.create(MainActivity.this,songRaw.get((myAudioAdapter.getCurrentPlayIndex())));
                                Log.d("inPlay",""+myAudioAdapter.getCurrentPlayIndex());
                                mPlayer.start();


                            }catch(Exception e){
                                e.printStackTrace();
                            }

                        });


                    }



                });




    }
}