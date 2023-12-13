package com.example.testapp.Lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testapp.R;

public class Lab04_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab04_main);

        ((Button)findViewById(R.id.btn_lab04_1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab04_Main.this, Lab04_1.class);
                startActivity(intent);
            }
        });
        ((Button)findViewById(R.id.btn_lab04_2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab04_Main.this, Lab04.class);
                startActivity(intent);
            }
        });
    }
}