package com.example.testapp.Lab02_3_Class;

public class EmployeeFullTime extends Employee {

    public EmployeeFullTime(String id, String name) {
        super(id, name);
    }
    public EmployeeFullTime(){

    }

    @Override
    public double TinhLuong() {

        return 0;
    }

    @Override
    public String toString() {
        return id + " - " + name + " --> FullTime=" + String.valueOf(TinhLuong()) ;
    }
}