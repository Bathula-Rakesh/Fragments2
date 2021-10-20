package com.example.fragments2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void page1(View view) {
        fragment= new Page1Fragment();
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mylayout,fragment);
        fragmentTransaction.commit();
    }

    public void page2(View view) {
        fragment = new Page2Fragment();
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mylayout,fragment);
        fragmentTransaction.commit();
    }

    public void page3(View view) {
        fragment = new Page3Fragment();
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mylayout,fragment);
        fragmentTransaction.commit();
    }
}