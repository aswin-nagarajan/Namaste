package com.venky97vp.android.namaste.adapters;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.venky97vp.android.namaste.R;
import com.venky97vp.android.namaste.classes.timetable.TTHour;

/**
 * Created by venky on 18-12-2017.
 */

public class HourViewHolder extends ChildViewHolder {
    private TextView artistName;

    public HourViewHolder(View itemView) {
        super(itemView);
        artistName = (TextView) itemView.findViewById(R.id.subject_name);
    }

    public void onBind(TTHour hour) {
        artistName.setText(hour.name);
    }
}
