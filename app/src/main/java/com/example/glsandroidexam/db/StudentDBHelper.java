package com.example.glsandroidexam.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.glsandroidexam.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "ExamStudent.db";
    private static final String TABLE_NAME = "student_table";
    private static final String STUDENT_COL_1 = "student_id";
    private static final String STUDENT_COL_2 = "student_fname";
    private static final String STUDENT_COL_3 = "student_lname";
    private static final String STUDENT_COL_4 = "student_sem";

    public StudentDBHelper(@Nullable Context context) {
        super(context, DB_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table IF NOT EXISTS "+TABLE_NAME+"(" +
                STUDENT_COL_1 + " TEXT," +
                STUDENT_COL_2 + " TEXT," +
                STUDENT_COL_3 + " TEXT," +
                STUDENT_COL_4 + " TEXT" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void insertData(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STUDENT_COL_1,student.getStudent_id());
        contentValues.put(STUDENT_COL_2,student.getStudent_fname());
        contentValues.put(STUDENT_COL_3,student.getStudent_lname());
        contentValues.put(STUDENT_COL_4,student.getStudent_sem());
        db.insert(TABLE_NAME, null, contentValues);
    }

    public List<Student> getData(){
        List<Student> result = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        while(res.moveToNext()){
            result.add(new Student(
                    res.getString(0),
                    res.getString(1),
                    res.getString(2),
                    res.getString(3)));
        }
        res.close();
        return result;
    }

    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,null,null);
    }
}
