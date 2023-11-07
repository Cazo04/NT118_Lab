package com.example.testapp.Lab02_3_Class;

public class EmployeePartTime extends Employee {

    public EmployeePartTime(String id, String name) {
        super(id, name);
    }

    public EmployeePartTime() {
    }

    @Override
    public double TinhLuong() {

        return 0;
    }

    @Override
    public String toString() {
        return id + " - " + name + " --> PartTime=" + String.valueOf(TinhLuong());
    }
}