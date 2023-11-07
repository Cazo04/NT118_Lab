package com.example.testapp.Lap02_5_Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testapp.R;

import java.util.List;

public class ThumbnailSpinnerAdapter extends ArrayAdapter<Thumbnail> {
    public ThumbnailSpinnerAdapter(Context context, List<Thumbnail> spinnerItems) {
        super(context, 0, spinnerItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_spiner, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.text_view_spinner_item);

        Thumbnail currentItem = getItem(position);

        if (currentItem != null) {
            textView.setText(currentItem.getName());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return initViews(position, convertView, parent);
    }

    private View initViews(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_spiner, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.text_view_spinner_item);
        ImageView imageView = convertView.findViewById(R.id.image_view_spinner_item);

        Thumbnail currentItem = getItem(position);

        if (currentItem != null) {
            textView.setText(currentItem.getName());
            imageView.setImageResource(currentItem.getImg());
        }

        return convertView;
    }
}
