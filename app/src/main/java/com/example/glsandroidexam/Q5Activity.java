package com.example.glsandroidexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Q5Activity extends AppCompatActivity {

    EditText et_cal_operand1,et_cal_operand2;
    TextView tv_cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q5);
        et_cal_operand1 = findViewById(R.id.et_cal_operand1);
        et_cal_operand2 = findViewById(R.id.et_cal_operand2);
        tv_cal = findViewById(R.id.tv_cal);
    }

    public void operatorClicked(View view) {
        double number1 = Double.parseDouble(et_cal_operand1.getText().toString());
        double number2 = Double.parseDouble(et_cal_operand2.getText().toString());
        double result = 0;
        switch (((TextView)view).getText().toString()){
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
        }

        String format = number1 + " "
                + ((TextView)view).getText().toString() + " "
                + number2 + " = "
                + new DecimalFormat("0.00").format(result);

        tv_cal.setText(format);
    }
}
