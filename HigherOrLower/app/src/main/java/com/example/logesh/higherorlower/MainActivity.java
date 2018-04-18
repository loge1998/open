package com.example.logesh.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    public  void guess (View view)
    {
        EditText editText = ( EditText )findViewById(R.id.editText);

        int input = Integer.parseInt(editText.getText().toString());
        String message ;
        if(randomNumber>input)
        {
            message = " higher ";
        }
        else if (randomNumber<input)
        {
            message = "lower ";
        }
        else
        {
            message = "You Got it!";
            generateRandomNumber();
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Log.i("random number" ,"button pressed");
        Log.i("data","editText.getText().toString()");
    }
    public void generateRandomNumber()
    {
        Random rand = new Random();
        randomNumber=rand.nextInt(20)+1;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandomNumber();
    }
}
