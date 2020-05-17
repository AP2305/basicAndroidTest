package com.example.glsandroidexam.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Student implements Parcelable {
    private String student_id,student_fname,student_lname,student_sem;

    public Student(String student_id, String student_fname, String student_lname, String student_sem) {
        this.student_id = student_id;
        this.student_fname = student_fname;
        this.student_lname = student_lname;
        this.student_sem = student_sem;
    }

    private Student(Parcel in) {
        student_id = in.readString();
        student_fname = in.readString();
        student_lname = in.readString();
        student_sem = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getStudent_id() {
        return student_id;
    }

    public String getStudent_fname() {
        return student_fname;
    }

    public String getStudent_lname() {
        return student_lname;
    }

    public String getStudent_sem() {
        return student_sem;
    }

    @Override
    @NonNull
    public String toString() {
        return  student_fname + " " + student_lname;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(student_id);
        dest.writeString(student_fname);
        dest.writeString(student_lname);
        dest.writeString(student_sem);
    }
}
