package com.example.testapp.Lab03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.testapp.R;

public class Lab03_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab033);

        ViewPager2 viewPager2 = findViewById(R.id.view_pager2);
        Lab03_ViewPagerAdapter adapter = new Lab03_ViewPagerAdapter(this);
        viewPager2.setAdapter(adapter);
    }
}