package com.example.glsandroidexam;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Q1Activity extends AppCompatActivity {

    EditText et_car_chasis,et_car_model,et_car_year;
    Spinner sp_car_type;
    CarDBHelper carDBHelper;
    NotificationCompat.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);
        createNotificationChannel();
        et_car_chasis = findViewById(R.id.et_car_chasis);
        et_car_model = findViewById(R.id.et_car_model);
        et_car_year = findViewById(R.id.et_car_year);
        sp_car_type = findViewById(R.id.sp_car_type);
        carDBHelper = new CarDBHelper(getApplicationContext());
        builder = new NotificationCompat.Builder(this,"normal")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Inserted!!")
                .setContentText("Record Added Successfully")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        Cursor cursor = carDBHelper.getData();
        Toast.makeText(this,cursor.getCount()+"",Toast.LENGTH_SHORT).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void registerClicked(View view) {
        if(carDBHelper.insertData(new Car(
                Integer.parseInt(et_car_chasis.getText().toString()),
                Integer.parseInt(et_car_year.getText().toString()),
                et_car_model.getText().toString(),
                sp_car_type.getSelectedItem().toString()))){

             NotificationManagerCompat manager = NotificationManagerCompat.from(this);
             manager.notify(1,builder.build());

        }
    }
    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) manager.createNotificationChannel(new NotificationChannel("normal","Car",NotificationManager.IMPORTANCE_DEFAULT));
        }
    }
}
