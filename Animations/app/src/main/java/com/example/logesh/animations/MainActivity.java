package com.example.logesh.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int count;

    public void fade()
    {
        count ++ ;
        Log.i("Info" , "Image Tapped");
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        ImageView homerimageView  = ( ImageView ) findViewById(R.id.homerimageView);
        if( count % 2 == 0) {
            imageView.animate().alpha(0).setDuration(2000);
            homerimageView.animate().alpha(1).setDuration(2000);
        }
        else
        {
            imageView.animate().alpha(1).setDuration(2000);
            homerimageView.animate().alpha(0).setDuration(2000);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count =0;
    }
}
