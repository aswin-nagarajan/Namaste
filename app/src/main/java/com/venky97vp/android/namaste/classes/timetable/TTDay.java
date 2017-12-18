package com.venky97vp.android.namaste.classes.timetable;

import android.os.Parcel;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by venky on 18-12-2017.
 */

public class TTDay extends ExpandableGroup<TTHour> {
    public TTDay(String title, List<TTHour> items) {
        super(title, items);
    }

    protected TTDay(Parcel in) {
        super(in);
    }
}
