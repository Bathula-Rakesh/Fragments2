package com.example.tablayoutproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MainFragment extends Fragment {

   //Initialize Text View
    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Initializing the view

        View view =inflater.inflate(R.layout.fragment_main, container, false);
        //Assign variable
        textView = view.findViewById(R.id.text_view);
        //get tittle
        String sTitle = getArguments().getString("title");
        //set tittle on te textView
        textView.setText(sTitle);
        return view;
    }
}