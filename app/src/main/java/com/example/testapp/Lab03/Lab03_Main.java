package com.example.testapp.Lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testapp.R;

public class Lab03_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab03_main);

        ((Button)findViewById(R.id.btn_lab03_1_2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab03_Main.this, Lab03_1.class);
                startActivity(intent);
            }
        });
        ((Button)findViewById(R.id.btn_lab03_3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab03_Main.this, Lab03_3.class);
                startActivity(intent);
            }
        });
    }
}