package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testapp.Lab02.Lab02_1;
import com.example.testapp.Lab02.Lab02_2;
import com.example.testapp.Lab02.Lab02_3;
import com.example.testapp.Lab02.Lab02_4;
import com.example.testapp.Lab02.Lab02_5;
import com.example.testapp.Lab02.Lab02_6;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.lab2_1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Lab02_1.class);
                startActivity(intent);
            }
        });

        ((Button)findViewById(R.id.lab2_2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Lab02_2.class);
                startActivity(intent);
            }
        });

        ((Button)findViewById(R.id.lab2_3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Lab02_3.class);
                startActivity(intent);
            }
        });
        ((Button)findViewById(R.id.lab2_4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Lab02_4.class);
                startActivity(intent);
            }
        });
        ((Button)findViewById(R.id.lab2_5)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Lab02_5.class);
                startActivity(intent);
            }
        });
        ((Button)findViewById(R.id.lab2_6)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Lab02_6.class);
                startActivity(intent);
            }
        });
    }
}