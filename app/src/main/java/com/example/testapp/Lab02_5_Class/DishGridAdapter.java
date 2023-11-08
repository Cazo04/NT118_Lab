package com.example.testapp.Lab02_5_Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testapp.R;

import java.util.List;

public class DishGridAdapter extends BaseAdapter {
    private Context context;
    private List<Dish> dishes;

    public DishGridAdapter(Context context, List<Dish> dishes) {
        this.context = context;
        this.dishes = dishes;
    }

    @Override
    public int getCount() {
        return dishes.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_dish, null);
        }
        ImageView imageView = view.findViewById(R.id.img_thumbnail);
        TextView textView = view.findViewById(R.id.txt_name);
        ImageView img_icon = view.findViewById(R.id.img_icon);

        imageView.setImageResource(dishes.get(i).getThumbnail().getImg());
        textView.setText(dishes.get(i).getName());

        if (!dishes.get(i).isPromotion()) img_icon.setVisibility(View.INVISIBLE);
        else img_icon.setVisibility(View.VISIBLE);

        return view;
    }
}
