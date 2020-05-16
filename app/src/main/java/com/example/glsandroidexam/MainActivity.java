package com.example.glsandroidexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void q4Clicked(View view) {
        startActivity(new Intent(getApplicationContext(),Q4Activity.class));
    }

    public void q2Clicked(View view) {
        startActivity(new Intent(getApplicationContext(),Q2Activity.class));
    }

    public void q1Clicked(View view) {
        startActivity(new Intent(getApplicationContext(),Q1Activity.class));
    }

    public void q5Clicked(View view) {
        startActivity(new Intent(getApplicationContext(),Q5Activity.class));
    }
}
