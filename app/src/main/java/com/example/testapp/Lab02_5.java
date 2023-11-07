package com.example.testapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.testapp.Lap02_5_Class.Thumbnail;
import com.example.testapp.Lap02_5_Class.ThumbnailSpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Lab02_5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab025);

        Spinner thumbnail_spiner = (Spinner) findViewById(R.id.spin_thumbnail);
        List<Thumbnail> thumbnailList = new ArrayList<>();
        thumbnailList.add(Thumbnail.Thumbnail1);
        thumbnailList.add(Thumbnail.Thumbnail2);
        thumbnailList.add(Thumbnail.Thumbnail3);
        thumbnailList.add(Thumbnail.Thumbnail4);
        ThumbnailSpinnerAdapter adapter = new ThumbnailSpinnerAdapter(this, thumbnailList);
        thumbnail_spiner.setAdapter(adapter);

    }
}