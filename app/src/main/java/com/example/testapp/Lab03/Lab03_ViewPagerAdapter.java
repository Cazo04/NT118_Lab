package com.example.testapp.Lab03;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Lab03_ViewPagerAdapter extends FragmentStateAdapter {
    public Lab03_ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0){
            return new Lab03_Fragment_1();
        } else return new Lab03_Fragment_2();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
