package com.example.logesh.sounddemo;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    public void play(View view)
    {
        mediaPlayer.start();
    }
    public void pause(View view)
    {
        mediaPlayer.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this,R.raw.car);
        audioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
        int maxvolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentvolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setMax(maxvolume);
        seekBar.setProgress(currentvolume);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("seekbar changed",String.valueOf(progress));
                audioManager.setStreamVolume(audioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final SeekBar scrubBar = (SeekBar)findViewById(R.id.scrubBar);
        scrubBar.setMax(mediaPlayer.getDuration());
        scrubBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("scrubbar",String.valueOf(progress));
                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scrubBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0 , 500);
    }
}
