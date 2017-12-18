package com.venky97vp.android.namaste.adapters;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;
import com.venky97vp.android.namaste.R;

/**
 * Created by venky on 18-12-2017.
 */

public class DaysViewHolder extends GroupViewHolder {
    private final TextView dayTitle;

    public DaysViewHolder(View itemView) {
        super(itemView);
        dayTitle = (TextView) itemView.findViewById(R.id.day_title);
    }

    public void setDayTitle(ExpandableGroup group) {
        dayTitle.setText(group.getTitle());
    }

//    @Override
//    public void expand() {
//        animateExpand();
//    }
//
//    @Override
//    public void collapse() {
//        animateCollapse();
//    }
}
