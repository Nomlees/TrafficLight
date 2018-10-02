package com.example.user.trafficlight;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button red;
    Button green;
    Button yellow;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout =  findViewById(R.id.linearLayout);
        red = findViewById(R.id.red);
        yellow = findViewById(R.id.yellow);
        green = findViewById(R.id.green);

        red.setOnClickListener( this);
        yellow.setOnClickListener( this);
        green.setOnClickListener( this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.red:
                linearLayout.setBackgroundColor(Color.RED);
                break;
            case R.id.yellow:
                linearLayout.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.green:
                linearLayout.setBackgroundColor(Color.GREEN);
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        View linear = findViewById(R.id.linearLayout);
        int color = Color.TRANSPARENT;
        Drawable background = linear.getBackground();
        if (background instanceof ColorDrawable)
            color = ((ColorDrawable) background).getColor();
        outState.putInt("background", color);


    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        View linear = findViewById(R.id.linearLayout);
        if (savedInstanceState != null && savedInstanceState.containsKey("background")) {
           linear.setBackgroundColor(savedInstanceState.getInt("background"));

        }
    }
}






