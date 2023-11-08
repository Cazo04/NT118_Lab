package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;

import com.example.testapp.Lab02_5_Class.Dish;
import com.example.testapp.Lab02_5_Class.DishGridAdapter;
import com.example.testapp.Lab02_5_Class.Thumbnail;
import com.example.testapp.Lab02_5_Class.ThumbnailSpinnerAdapter;

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

        GridView grid_dish = (GridView) findViewById(R.id.grid_dish);
        List<Dish> dishes = new ArrayList<>();
        DishGridAdapter dishGridAdapter = new DishGridAdapter(this, dishes);
        grid_dish.setAdapter(dishGridAdapter);

        ((Button) findViewById(R.id.btn_add)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thumbnail thumbnail = (Thumbnail) thumbnail_spiner.getSelectedItem();
                String name = ((EditText) findViewById(R.id.edit_name)).getText().toString();
                boolean promotion = ((CheckBox) findViewById(R.id.check_promotion)).isChecked();

                //Toast.makeText(Lab02_5.this, String.valueOf(promotion), Toast.LENGTH_SHORT).show();
                Dish dish = new Dish();
                dish.setName(name);
                dish.setThumbnail(thumbnail);
                dish.setPromotion(promotion);

                dishes.add(dish);
                dishGridAdapter.notifyDataSetChanged();
            }
        });
    }
}