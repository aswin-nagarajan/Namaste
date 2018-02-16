package com.venky97vp.android.namaste.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.venky97vp.android.namaste.R;
import com.venky97vp.android.namaste.adapters.CustomPagerAdapter;
import com.venky97vp.android.namaste.adapters.ExistingAssgtPagerAdapter;
import com.venky97vp.android.namaste.adapters.NewAssignmentAdapter;
import com.venky97vp.android.namaste.classes.Assignment;
import com.venky97vp.android.namaste.classes.AssignmentQuestion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Aswin Nagarajan on 15-02-2018.
 */

public class ExistingAssignment extends Fragment {

    // Store instance variables
    private String title;
    private int page;
    private AssignmentFragment.OnFragmentInteractionListener mListener;
    ViewPager viewPager;

    // newInstance constructor for creating fragment with arguments
    public static Fragment newInstance(int page, String title) {
        Fragment fragmentFirst = new ExistingAssignment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.existing_assgt, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager_exist);
        viewPager.setAdapter(new ExistingAssgtPagerAdapter(getFragmentManager()));
        return view;
    }




    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}


