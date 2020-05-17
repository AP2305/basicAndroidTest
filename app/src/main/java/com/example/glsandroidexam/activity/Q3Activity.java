package com.example.glsandroidexam.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.glsandroidexam.R;
import com.example.glsandroidexam.db.StudentDBHelper;
import com.example.glsandroidexam.model.Student;

import java.util.List;

public class Q3Activity extends AppCompatActivity {

    StudentDBHelper studentDBHelper;
    EditText et_std_id,et_std_fname,et_std_lname;
    RadioGroup rg_student;
    RadioButton rb_selected;
    Spinner sp_student;
    List<Student> studentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q3);
        et_std_id = findViewById(R.id.et_std_id);
        et_std_fname = findViewById(R.id.et_std_fname);
        et_std_lname = findViewById(R.id.et_std_lname);
        rg_student = findViewById(R.id.rg_std);
        sp_student = findViewById(R.id.sp_student);
        studentDBHelper = new StudentDBHelper(getApplicationContext());
        updateSpinner();
    }

    private void updateSpinner() {
        studentList = studentDBHelper.getData();
        studentList.add(0,new Student("-1","Select a Student","",""));
        sp_student.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, studentList));
    }

    public void registerStudentClicked(View view) {
        if(et_std_id.getText().toString().equals("")
                ||et_std_fname.getText().toString().equals("")
                ||et_std_lname.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(),"Empty Values not allowed",Toast.LENGTH_SHORT).show();
            return;
        }
        rb_selected = findViewById(rg_student.getCheckedRadioButtonId());
        studentDBHelper.insertData(new Student(
                et_std_id.getText().toString(),
                et_std_fname.getText().toString(),
                et_std_lname.getText().toString(),
                rb_selected.getText().toString()
        ));
        updateSpinner();
        reset();
    }

    private void reset() {
        et_std_id.setText("");
        et_std_fname.setText("");
        et_std_lname.setText("");
    }

    public void calculateGradeClicked(View view) {
        if(sp_student.getSelectedItemPosition()==0)
            Toast.makeText(getApplicationContext(),"Select a student first",Toast.LENGTH_SHORT).show();
        else{
            startActivity(
                    new Intent(getApplicationContext(),Q3ActivityGrades.class)
                            .putExtra("studentObj",(Student)sp_student.getSelectedItem()));
        }
    }

    public void deleteStudentClicked(View view) {
        studentDBHelper.deleteAll();
        updateSpinner();
    }
}
