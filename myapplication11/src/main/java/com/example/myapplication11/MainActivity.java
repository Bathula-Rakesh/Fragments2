package com.example.myapplication11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    MyPageAdapter myPageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=findViewById(R.id.Tab);
        viewPager=findViewById(R.id.viewPager);

        myPageAdapter=new MyPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myPageAdapter);

        tabLayout.setupWithViewPager(viewPager);

    }
}