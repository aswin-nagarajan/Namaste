package com.venky97vp.android.namaste.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.venky97vp.android.namaste.R;
import com.venky97vp.android.namaste.classes.Presence;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Aswin Nagarajan on 05-02-2018.
 */

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceEntryViewHolder>{

    Context context;
    List<Presence> attendanceList;
    public AttendanceAdapter(Context ctx, List<Presence> list) {
        this.context= ctx;
        this.attendanceList = list;
    }

    @Override
    public AttendanceEntryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.attendance_entry, null);
        return new AttendanceEntryViewHolder(v,context);
    }

    @Override
    public void onBindViewHolder(final AttendanceEntryViewHolder holder, int position) {
        Presence p = attendanceList.get(position);
        holder.isAbsent.setChecked(p.isAbsent());
        holder.isPresent.setChecked(p.isPresent());
        holder.name.setText(p.getName());
        holder.rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.Pres:
                        change(0,holder);
                        break;
                    case R.id.Abs:
                        change(1,holder);
                        break;
                }
            }
        });
    }

    public void change(int v, AttendanceEntryViewHolder holder){
        if(v==0){
            holder.ll.setBackgroundColor(context.getResources().getColor(R.color.green));
        }
        if(v==1){
            holder.ll.setBackgroundColor(context.getResources().getColor(R.color.red));
        }

    }

    @Override
    public int getItemCount() {
        return attendanceList.size();
    }
}
