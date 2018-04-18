package com.example.logesh.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public class Number
    {
        int number;

        public boolean isSquare()
        {
            double SquareRoot = Math.sqrt(number);
            if( SquareRoot == Math.floor(SquareRoot) )
            {
                return true;
            }
            else
                return false;

        }

        public boolean istriangle()
        {
            int x=1;
            int triangleNumber = 1;
            while(triangleNumber < number )
            {
                x++;
                triangleNumber += x;
            }
            if( triangleNumber == number )
            {
                return true;
            }
            else
                return  false;
        }


    }



    public void testNumber(View view)
    {
        Log.i("info", "button pressed");

        EditText editText = (EditText) findViewById(R.id.editText);

        String message;

        if(editText.getText().toString().isEmpty())
        {
            message = "Plse enter a number";
        }
        else {

            Number myNumber = new Number();

            myNumber.number = Integer.parseInt(editText.getText().toString());

            if (myNumber.isSquare() && myNumber.istriangle()) {
                message = "both square and triangular";
            } else if (myNumber.istriangle()) {
                message = " Triangular number";
            } else if (myNumber.isSquare()) {
                message = "Square Number";
            } else {
                message = "neither square nor triangular";
            }
        }
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
