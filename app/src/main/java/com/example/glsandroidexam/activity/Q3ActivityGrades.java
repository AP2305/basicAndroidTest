package com.example.glsandroidexam.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.glsandroidexam.R;
import com.example.glsandroidexam.model.Student;

import java.text.DecimalFormat;
import java.util.Objects;

public class Q3ActivityGrades extends AppCompatActivity {

    TextView tv_std_id,tv_std_fname,tv_std_lname,tv_std_sem1,tv_std_sem2,tv_std_results;
    EditText et_egp1,et_credits1,et_egp2,et_credits2;
    Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q3_grades);
        tv_std_id = findViewById(R.id.tv_std_id);
        tv_std_fname = findViewById(R.id.tv_std_fname);
        tv_std_lname = findViewById(R.id.tv_std_lname);
        tv_std_sem1 = findViewById(R.id.tv_std_sem1);
        tv_std_sem2 = findViewById(R.id.tv_std_sem2);
        tv_std_results = findViewById(R.id.tv_std_results);
        et_egp1 = findViewById(R.id.et_egp1);
        et_credits1 = findViewById(R.id.et_credit1);
        et_egp2 = findViewById(R.id.et_egp2);
        et_credits2 = findViewById(R.id.et_credit2);
        student = Objects.requireNonNull(getIntent().getExtras()).getParcelable("studentObj");
        if (student != null) {
            String format = "Student Id: " + student.getStudent_id();
            tv_std_id.setText(format);
            format = "First Name: " + student.getStudent_fname();
            tv_std_fname.setText(format);
            format = "Last name: " + student.getStudent_lname();
            tv_std_lname.setText(format);
            if(student.getStudent_sem().equals("Sem I")){
                tv_std_sem2.setVisibility(View.INVISIBLE);
                et_egp2.setVisibility(View.INVISIBLE);
                et_credits2.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void calculateGrades(View view) {
        if(et_egp1.getText().toString().equals("")
                ||et_credits1.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(),"Empty Values not allowed",Toast.LENGTH_SHORT).show();
            return;
        }
        int egp1 = Integer.parseInt(et_egp1.getText().toString());
        int credit1 = Integer.parseInt(et_credits1.getText().toString());
        double sgpa1 = Double.parseDouble(new DecimalFormat("0.00").format(egp1/credit1));
        double percent = sgpa1 * 10;
        double cgpa = sgpa1;
        String format = "SGPA Sem I: " + sgpa1;
        if(!student.getStudent_sem().equals("Sem I")){
            if(et_egp2.getText().toString().equals("")
                    ||et_credits2.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(),"Empty Values not allowed",Toast.LENGTH_SHORT).show();
                return;
            }
            int egp2 = Integer.parseInt(et_egp2.getText().toString());
            int credit2 = Integer.parseInt(et_credits2.getText().toString());
            double sgpa2 = Double.parseDouble(new DecimalFormat("0.00").format(egp2/credit2));
            cgpa = (sgpa1 + sgpa2) / 2;
            percent = cgpa * 10;
            format += "\nSGPA Sem II: " + sgpa2;
        }
        format += "\nCGPA: " + cgpa;
        format += "\nPercentage: " + percent;
        tv_std_results.setText(format);
    }
}
