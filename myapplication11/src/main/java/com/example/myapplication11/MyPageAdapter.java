package com.example.myapplication11;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

public class MyPageAdapter  extends FragmentPagerAdapter {
    Fragment fragment;
    String string;
    public MyPageAdapter(@NonNull @NotNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Fragment getItem(int position) {
        fragment =new Fragment();
        switch(position){
            case 0:
                fragment=new Page1Fragment();
                break;
            case 1:
                fragment=new Page2Fragment();
                break;
            case 2:
                fragment=new Page3Fragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                string = "chats";
                break;
            case 1:
                string = "status";
                break;
            case 2:
                string = "calls";
                break;
        }
        return string;
    }
}
