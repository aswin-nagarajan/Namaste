package com.venky97vp.android.namaste.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.venky97vp.android.namaste.R;
import com.venky97vp.android.namaste.classes.Presence;
import com.venky97vp.android.namaste.classes.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Aswin Nagarajan on 05-02-2018.
 */

public class AttendanceAdapter extends FirebaseRecyclerAdapter<Student, AttendanceEntryViewHolder> {

    Context context;
    List<Presence> attendanceList;

    public AttendanceAdapter(Class<Student> modelClass, int modelLayout, Class<AttendanceEntryViewHolder> viewHolderClass, DatabaseReference ref, Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        this.context= context;
    }

    public List<Presence> getItemList(){
        List<Presence> list = new ArrayList<Presence>();
        for (int pos=0; pos< this.getItemCount();pos++){
            list.add(new Presence(getItem(pos)));
        }

        return list;
    }

    @Override
    public AttendanceEntryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.attendance_entry, null);
        return new AttendanceEntryViewHolder(v,context);
    }

    @Override
    protected void populateViewHolder(AttendanceEntryViewHolder vholder, Student model, int position){
        final AttendanceEntryViewHolder holder = vholder;
        Presence p = new Presence(model);
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

}
