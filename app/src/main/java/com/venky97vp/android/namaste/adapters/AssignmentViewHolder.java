package com.venky97vp.android.namaste.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.venky97vp.android.namaste.R;

/**
 * Created by Aswin Nagarajan on 15-02-2018.
 */

public class AssignmentViewHolder extends RecyclerView.ViewHolder {

    TextView title, id, date, stud, percentage;
    public AssignmentViewHolder(View itemView, Context ctx){
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.assg_title);
        id = (TextView) itemView.findViewById(R.id.id);
        date = (TextView) itemView.findViewById(R.id.deadline);
        stud = (TextView) itemView.findViewById(R.id.stud);
        percentage = (TextView) itemView.findViewById(R.id.percentage);
    }


}
