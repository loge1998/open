package com.example.logesh.currencyconvertor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convert (View view){
        Log.i("Info","Button Pressed");
        EditText editText = (EditText) findViewById(R.id.editText);
        String amountinpounds = editText.getText().toString();
        double d = Double.parseDouble(amountinpounds);
        d = d *1.3;
        String amountindollars = String.format("%.2f",d);
        Toast.makeText(this, amountindollars, Toast.LENGTH_SHORT).show();
        Log.i("Values",amountindollars);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
