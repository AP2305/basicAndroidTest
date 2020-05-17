package com.example.glsandroidexam.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.glsandroidexam.R;

public class Q4Activity extends AppCompatActivity {

    EditText et_factorial,et_sod,et_palindrome;
    TextView tv_factorial,tv_sod,tv_palindrome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q4);
        et_factorial = findViewById(R.id.et_factorial);
        tv_factorial = findViewById(R.id.tv_factorial);
        et_sod = findViewById(R.id.et_sod);
        tv_sod = findViewById(R.id.tv_sod);
        et_palindrome = findViewById(R.id.et_palindrome);
        tv_palindrome = findViewById(R.id.tv_palindrome);
        TabHost tabHost = findViewById(R.id.tab_host);
        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("First");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Factorial");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Second");
        tabSpec.setContent(R.id.tab2);
        tabSpec.setIndicator("Sum of Digits");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Third");
        tabSpec.setContent(R.id.tab3);
        tabSpec.setIndicator("Palindrome");
        tabHost.addTab(tabSpec);
    }

    public void calculateFactorial(View view) {
        if(et_factorial.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(),"Empty Values not allowed",Toast.LENGTH_SHORT).show();
            return;
        }
        int number = Integer.parseInt(et_factorial.getText().toString());
        String format = number+"! = "+factorial(number);
        tv_factorial.setText(format);
    }

    private long factorial(int number) {
        long ans = 1;
        for(int i=number;i>=1;i--) ans *= i;
        return ans;
    }


    public void calculateSumOfDigits(View view) {
        if(et_sod.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(),"Empty Values not allowed",Toast.LENGTH_SHORT).show();
            return;
        }
        int number = Integer.parseInt(et_sod.getText().toString());
        String format = "Sum of Digits = "+sumOfDigits(number);
        tv_sod.setText(format);
    }

    private int sumOfDigits(int number) {
        int ans = 0,temp;
        while(number>0){
            temp = number%10;
            ans += temp;
            number/=10;
        }
        return ans;
    }

    public void checkPalindrome(View view) {
        if(et_palindrome.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(),"Empty Values not allowed",Toast.LENGTH_SHORT).show();
            return;
        }
        String format = et_palindrome.getText().toString() + " is" + isPalindrome(et_palindrome.getText().toString()) + " a Palindrome";
        tv_palindrome.setText(format);
    }

    private String isPalindrome(String inputString) {
        return new StringBuilder(inputString).reverse().toString().equals(inputString)?"":" not";
    }
}
