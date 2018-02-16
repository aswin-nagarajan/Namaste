package com.venky97vp.android.namaste.adapters;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import com.venky97vp.android.namaste.fragments.ExistingAssignment;
import com.venky97vp.android.namaste.fragments.ExistingAssignmentPackage.NotReviewedAssignment;
import com.venky97vp.android.namaste.fragments.ExistingAssignmentPackage.ReviewedAssignment;
import com.venky97vp.android.namaste.fragments.NewAssignment;

/**
 * Created by Aswin Nagarajan on 15-02-2018.
 */

public class ExistingAssgtPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 2;
    public ExistingAssgtPagerAdapter(FragmentManager fm) {
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
                Log.d("mess", "inside switch");
                return NotReviewedAssignment.newInstance(0, "Page # 1");
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return ReviewedAssignment.newInstance(1, "Page # 2");
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Not Reviewed";
        }
        else{
            return "Reviewed";
        }
    }


}

