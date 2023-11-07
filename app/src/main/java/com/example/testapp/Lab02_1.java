package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Lab02_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab021);

        ListView list = (ListView) findViewById(R.id.list);

        final String arr[] = {"Teo", "Ty", "Bin", "Bo"};

        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arr);

        list.setAdapter(adapter);

    }
}