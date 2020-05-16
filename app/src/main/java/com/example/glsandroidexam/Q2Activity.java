package com.example.glsandroidexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Q2Activity extends AppCompatActivity {

    EditText et_currency;
    TextView tv_currency;
    Spinner sp_currency;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q2);
        et_currency = findViewById(R.id.et_currency);
        tv_currency = findViewById(R.id.tv_currency);
        sp_currency = findViewById(R.id.sp_currency);
    }

    public void convertCurrency(View view) {
        double result=0;
        String convert="";
        int amount = Integer.parseInt(et_currency.getText().toString());
        int selectedIndex = Arrays.asList(
                getResources().getStringArray(R.array.currency_conversions))
                .indexOf(sp_currency.getSelectedItem().toString());
        switch (selectedIndex){
            case 0:
                result = amount*0.02;
                convert = "USD";
                break;
            case 1:
                result = amount*1.50;
                convert = "JPY";
                break;
            case 2:
                result = amount*0.013;
                convert = "EUR";
                break;
            case 3:
                result = amount*0.012;
                convert = "GBP";
                break;
        }
        String format = amount + " INR = " + new DecimalFormat("0.00").format(result) + " " + convert;
        tv_currency.setText(format);
    }
}
