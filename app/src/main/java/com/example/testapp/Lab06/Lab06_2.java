package com.example.testapp.Lab06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.testapp.R;

public class Lab06_2 extends AppCompatActivity {

    private PowerStateChangeReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab062);
    }
}