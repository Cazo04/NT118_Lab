package com.example.testapp.Lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testapp.R;

public class Lab05_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab05_main);

        ((Button)findViewById(R.id.btn_lab05_1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab05_Main.this, Lab05_1.class);
                startActivity(intent);
            }
        });
        ((Button)findViewById(R.id.btn_lab05_2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab05_Main.this, Lab05_2.class);
                startActivity(intent);
            }
        });
        ((Button)findViewById(R.id.btn_lab05_3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab05_Main.this, Lab05_3.class);
                startActivity(intent);
            }
        });
        ((Button)findViewById(R.id.btn_lab05_final)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab05_Main.this, Lab05_Final.class);
                startActivity(intent);
            }
        });
    }
}