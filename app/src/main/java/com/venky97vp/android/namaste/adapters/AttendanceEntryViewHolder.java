package com.venky97vp.android.namaste.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.venky97vp.android.namaste.R;

/**
 * Created by Aswin Nagarajan on 05-02-2018.
 */

public class AttendanceEntryViewHolder extends RecyclerView.ViewHolder{

    public RadioButton isPresent;
    public RadioButton isAbsent;
    public TextView name;
    String id;
    RelativeLayout ll;
    Context ctx;
    RadioGroup rg;
    public AttendanceEntryViewHolder(View itemView, Context ctx) {
        super(itemView);
        isPresent = (RadioButton) itemView.findViewById(R.id.Pres);
        isAbsent = (RadioButton) itemView.findViewById(R.id.Abs);
        name = (TextView) itemView.findViewById(R.id.name);
        ll = (RelativeLayout) itemView.findViewById(R.id.layout);
        rg=(RadioGroup) itemView.findViewById(R.id.radiogroup);
        this.ctx = ctx;
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.Pres:
                if (checked)
                    ll.setBackgroundColor(ctx.getResources().getColor(R.color.green));
                    break;
            case R.id.Abs:
                if (checked)
                    ll.setBackgroundColor(ctx.getResources().getColor(R.color.red));
                    break;
        }
    }
}
