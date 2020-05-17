package com.example.glsandroidexam.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.glsandroidexam.R;
import com.example.glsandroidexam.db.CarDBHelper;

public class Q1ActivitySearch extends AppCompatActivity {

    EditText et_search;
    TextView tv_search;
    CarDBHelper carDBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1_search);
        tv_search = findViewById(R.id.tv_search);
        et_search = findViewById(R.id.et_search);
        carDBHelper = new CarDBHelper(getApplicationContext());
        tv_search.setText(carDBHelper.getData());
    }

    public void deleteClicked(View view) {
        carDBHelper.deleteAll();
        tv_search.setText(carDBHelper.getData());
    }

    public void searchCarClicked(View view) {
        if(et_search.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(),"Empty Values not allowed",Toast.LENGTH_SHORT).show();
            return;
        }
        tv_search.setText(carDBHelper.getData(Integer.parseInt(et_search.getText().toString())));
    }
}
