 package com.example.logesh.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {

     int[] gamestate = {2,2,2,2,2,2,2,2,2};

     int[][] Winningposition = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

     int activeplayer = 0 ;

     boolean gameactive = true;

     int count =0;

     public void dropIn(View view){

        ImageView counter = (ImageView) view;

        Log.i("tag","tag is " + counter.getTag().toString());

        int tappedcounter = Integer.parseInt(counter.getTag().toString());

        if(gamestate[tappedcounter]==2 && gameactive) {

            gamestate[tappedcounter] = activeplayer;

            counter.setTranslationY(-1500);

            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activeplayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activeplayer = 0;
            }

            String winner ="";
            counter.animate().translationYBy(1500).setDuration(300);

            for (int[] winningposition : Winningposition) {
                if (gamestate[winningposition[0]] == gamestate[winningposition[1]] &&
                        gamestate[winningposition[0]] == gamestate[winningposition[2]] &&
                        gamestate[winningposition[1]] == gamestate[winningposition[2]] && gamestate[winningposition[0]] != 2) {
                        if(activeplayer==1)
                            winner="Yellow";
                        else
                            winner="red";
                    Button button = (Button)findViewById(R.id.button);
                    TextView textView = (TextView)findViewById(R.id.textView);
                    button.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);
                    textView.setText(winner+" has won ");
                    gameactive=false;
                    break;
                }
            }
            count++;
            Log.i("info",String.valueOf(count));
            Log.i("info",String.valueOf(gameactive));
            if(gameactive && count == 9)
            {
                Button button =(Button)findViewById(R.id.button);
                TextView textView = (TextView)findViewById(R.id.textView);
                button.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                textView.setText("Draw");
                gameactive=false;
            }
        }
    }
    public void Again(View view) {
        Button button = (Button) findViewById(R.id.button);
        TextView textView = (TextView) findViewById(R.id.textView);
        button.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);
        android.support.v7.widget.GridLayout gridLayout = findViewById(R.id.gridLayout);
        Log.i("info", String.valueOf(gridLayout.getChildCount()));
        for (int i = 0; i < gridLayout.getChildCount(); i++)
        {
            ImageView counter = (ImageView)gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }
        for(int i=0;i<gamestate.length;i++)
        {
            gamestate[i]=2;
        }
        activeplayer = 0 ;
        gameactive = true;
        count=0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
