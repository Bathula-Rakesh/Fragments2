package com.example.tablayoutproject;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign variable
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        //Intialiaze array List

        ArrayList<String> arrayList = new ArrayList<>();

        //Add tittle to array List
        arrayList.add("Chats-1");
        arrayList.add("Status-1");
        arrayList.add("Calls-1");

        //set up tab layout
        tabLayout.setupWithViewPager(viewPager);

        //Prepare ViewPager
        prepareViewPager(viewPager,arrayList);

    }

    private void prepareViewPager(ViewPager viewPager, ArrayList<String> arrayList) {
        //Initialize main adapter
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        //Initialize main fragment
        MainFragment mainFragment = new MainFragment();
        //use for loop
        for(int i=0;i<arrayList.size();i++){
            //Initialize the bundle
            Bundle bundle = new Bundle();
            //Put titttle
            bundle.putString("title",arrayList.get(i));
            //set argument
            mainFragment.setArguments(bundle);
            //Add fragments
            adapter.addFragment(mainFragment,arrayList.get(i));
            mainFragment = new MainFragment();

        }
        //set Adapter
        viewPager.setAdapter(adapter);
    }

    private class MainAdapter  extends FragmentPagerAdapter {
        //initialize Arraylist
        ArrayList<Fragment> fragmentsArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<String>();
        int[] imagelist = {R.drawable.ic_baseline_chat_24,R.drawable.account,R.drawable.ic_baseline_call_24};

        //create constructor
        public void addFragment(Fragment fragment,String s){
            //Add Fragments
            fragmentsArrayList.add(fragment);
            stringArrayList.add(s);
        }

        public MainAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @NonNull
        @org.jetbrains.annotations.NotNull
        @Override
        public Fragment getItem(int position) {
            return fragmentsArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentsArrayList.size();
        }

        @Nullable
        @org.jetbrains.annotations.Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            //Initialize drawable
            Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),imagelist[position]);
            //set bound
            drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
            //Initialize spannable String
            SpannableString spannableString= new SpannableString(" "+
                    stringArrayList.get(position));
            //Initialize image Span
            ImageSpan imageSpan = new ImageSpan(drawable,ImageSpan.ALIGN_BOTTOM);
            //set span
            spannableString.setSpan(imageSpan,0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            //Return spannable string
            return spannableString;


        }
    }
}