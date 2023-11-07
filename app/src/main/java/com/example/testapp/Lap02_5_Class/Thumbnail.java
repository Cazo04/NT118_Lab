package com.example.testapp.Lap02_5_Class;

import com.example.testapp.R;

public enum Thumbnail {
    Thumbnail1("Thumbnail 1", R.drawable.thumbnail_1),
    Thumbnail2("Thumbnail 2", R.drawable.thumbnail_2),
    Thumbnail3("Thumbnail 3", R.drawable.thumbnail_3),
    Thumbnail4("Thumbnail 4", R.drawable.thumbnail_4);

    private String name;
    private int img;
    Thumbnail(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }
}
