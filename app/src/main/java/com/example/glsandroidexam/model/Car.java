package com.example.glsandroidexam.model;

public class Car {
    private int car_chasis_no,car_year;
    private String car_model,car_type;

    public Car(int car_chasis_no, int car_year, String car_model, String car_type) {
        this.car_chasis_no = car_chasis_no;
        this.car_year = car_year;
        this.car_model = car_model;
        this.car_type = car_type;
    }

    public int getCar_chasis_no() {
        return car_chasis_no;
    }

    public int getCar_year() {
        return car_year;
    }

    public String getCar_model() {
        return car_model;
    }

    public String getCar_type() {
        return car_type;
    }
}
