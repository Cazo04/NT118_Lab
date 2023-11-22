package com.example.testapp.Lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testapp.R;

public class Lab03_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab032);

        ((Button)findViewById(R.id.btn_back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab03_2.this, Lab03_1.class);

                startActivity(intent);
                overridePendingTransition(R.anim.anim_left_to_right, R.anim.anim_right_to_left);
                finish();
            }
        });
    }
}