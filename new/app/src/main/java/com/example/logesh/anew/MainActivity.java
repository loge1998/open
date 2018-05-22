package com.example.logesh.anew;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int count =0;
    public void fade(View view)
    {
        Log.i("info" ,"image clicked"+ count );
        ImageView cat1 = (ImageView) findViewById(R.id.cat1);
        ImageView cat2 = (ImageView) findViewById(R.id.cat2);

        if(count%2==0) {
            cat1.animate().translationXBy(-1000).rotation(3600).setDuration(2000);
            cat2.animate().translationXBy(1000).rotation(3600).setDuration(2000);
        }
        else
        {
            cat1.animate().translationXBy(1000).rotation(3600).setDuration(2000);
            cat2.animate().translationXBy(-1000).rotation(3600).setDuration(2000);
        }
        count++;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView cat1 = (ImageView) findViewById(R.id.cat1);
        ImageView cat2 = (ImageView) findViewById(R.id.cat2);
        cat2.setX(-1000);
    }
}
