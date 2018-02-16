package com.venky97vp.android.namaste.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.venky97vp.android.namaste.fragments.ExistingAssignment;
import com.venky97vp.android.namaste.fragments.NewAssignment;

/**
 * Created by Aswin Nagarajan on 15-02-2018.
 */

public class CustomPagerAdapter extends FragmentPagerAdapter{

    private static int NUM_ITEMS = 2;
    public CustomPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }




    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return NewAssignment.newInstance(0, "Page # 1");
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return ExistingAssignment.newInstance(1, "Page # 2");
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "New";
        }
        else{
            return "Existing";
        }
    }


}
