package com.example.glsandroidexam.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.glsandroidexam.model.Car;

public class CarDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Exam.db";
    private static final String TABLE_NAME = "car_table";
    private static final String CAR_COL_1 = "car_chasis_no";
    private static final String CAR_COL_2 = "car_model";
    private static final String CAR_COL_3 = "car_type";
    private static final String CAR_COL_4 = "car_year";

    public CarDBHelper(@Nullable Context context) {
        super(context, DB_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table IF NOT EXISTS "+TABLE_NAME+"(" +
                CAR_COL_1 + " INTEGER," +
                CAR_COL_2 + " TEXT," +
                CAR_COL_3 + " TEXT," +
                CAR_COL_4 + " INTEGER" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(Car car){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CAR_COL_1,car.getCar_chasis_no());
        contentValues.put(CAR_COL_2,car.getCar_model());
        contentValues.put(CAR_COL_3,car.getCar_type());
        contentValues.put(CAR_COL_4,car.getCar_year());
        return db.insert(TABLE_NAME, null, contentValues) != -1;
    }

    public String getData(){
        StringBuilder result;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        if(res.getCount()<1) result = new StringBuilder("No Records in the Database");
        else{
            result = new StringBuilder("Cars\nc:Chasis\tm:Model\tt:Type\ty:Year");
            while(res.moveToNext()){
                result.append("\n")
                        .append("c: ").append(res.getInt(0))
                        .append("  m: ").append(res.getString(1))
                        .append("  t: ").append(res.getString(2))
                        .append("  y: ").append(res.getInt(3));
            }
        }
        res.close();
        return result.toString();
    }

    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,null,null);
    }

    public String getData(int chasis) {
        StringBuilder result;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME
                +" WHERE "+CAR_COL_1+" = "+chasis,null);
        if(res.getCount()<1) result = new StringBuilder("No Records in the Database");
        else{
            result = new StringBuilder("Cars\nc:Chasis\tm:Model\tt:Type\ty:Year");
            while(res.moveToNext()){
                result.append("\n")
                        .append("c: ").append(res.getInt(0))
                        .append("  m: ").append(res.getString(1))
                        .append("  t: ").append(res.getString(2))
                        .append("  y: ").append(res.getInt(3));
            }
        }
        res.close();
        return result.toString();
    }
}
