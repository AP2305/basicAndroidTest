package com.example.glsandroidexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.glsandroidexam.activity.Q1Activity;
import com.example.glsandroidexam.activity.Q2Activity;
import com.example.glsandroidexam.activity.Q3Activity;
import com.example.glsandroidexam.activity.Q4Activity;
import com.example.glsandroidexam.activity.Q5Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void q4Clicked(View view) {
        startActivity(new Intent(getApplicationContext(), Q4Activity.class));
    }

    public void q2Clicked(View view) {
        startActivity(new Intent(getApplicationContext(), Q2Activity.class));
    }

    public void q1Clicked(View view) {
        startActivity(new Intent(getApplicationContext(), Q1Activity.class));
    }

    public void q5Clicked(View view) {
        startActivity(new Intent(getApplicationContext(), Q5Activity.class));
    }

    public void q3Clicked(View view) {
        startActivity(new Intent(getApplicationContext(), Q3Activity.class));
    }
}
