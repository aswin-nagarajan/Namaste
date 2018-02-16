package com.venky97vp.android.namaste.fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.venky97vp.android.namaste.R;
import com.venky97vp.android.namaste.adapters.ScheduleTabAdapter;

import java.util.Calendar;
import java.util.Date;

import static android.content.ContentValues.TAG;

public class TimetableFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private TabLayout tabs;

    public TimetableFragment() {
        // Required empty public constructor
    }

    private void setupViewPager(ViewPager viewPager) {
        ScheduleTabAdapter adapter = new ScheduleTabAdapter(getChildFragmentManager());
        Fragment day1 = new DayFragment();
        adapter.addFragment(day1, "Monday");
        Fragment day2 = new DayFragment();
        adapter.addFragment(day2, "Tuesday");
        Fragment day3 = new DayFragment();
        adapter.addFragment(day3, "Wednesday");
        Fragment day4 = new DayFragment();
        adapter.addFragment(day4, "Thursday");
        Fragment day5 = new DayFragment();
        adapter.addFragment(day5, "Friday");
        viewPager.setAdapter(adapter);
    }

    private void changeTabsFont() {
        ViewGroup vg = (ViewGroup) tabs.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(Typeface.createFromAsset(getContext().getAssets(), "font/JosefinSans-Regular.ttf"));
                }
            }
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timetable, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabs = (TabLayout) view.findViewById(R.id.result_tabs);
        tabs.setupWithViewPager(viewPager);
        changeTabsFont();
        int week = getDayOfWeek(new Date(System.currentTimeMillis())) - 2;
        TabLayout.Tab tab = tabs.getTabAt(week);
        Log.d(TAG, "onCreateView: " + week);
        if (tab != null) {
            Log.d(TAG, "onCreateView: " + week);
            tab.select();
        }
        return view;
    }

    public int getDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_WEEK);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
