package com.venky97vp.android.namaste.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.venky97vp.android.namaste.R;
import com.venky97vp.android.namaste.classes.timetable.TTDay;
import com.venky97vp.android.namaste.classes.timetable.TTHour;

import java.util.List;

/**
 * Created by venky on 18-12-2017.
 */

public class DaysAdapter extends ExpandableRecyclerViewAdapter<DaysViewHolder, HourViewHolder> {
    private final LayoutInflater inflater;

    public DaysAdapter(Context context, List<? extends ExpandableGroup> groups) {
        super(groups);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public DaysViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.each_day, parent, false);
        return new DaysViewHolder(view);
    }

    @Override
    public HourViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.each_hour, parent, false);
        return new HourViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(HourViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final TTHour hour = ((TTDay) group).getItems().get(childIndex);
        holder.onBind(hour);
    }

    @Override
    public void onBindGroupViewHolder(DaysViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setDayTitle(group);
    }
}
