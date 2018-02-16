package com.venky97vp.android.namaste.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.venky97vp.android.namaste.R;
import com.venky97vp.android.namaste.classes.Assignment;

import java.util.List;

/**
 * Created by Aswin Nagarajan on 15-02-2018.
 */

public class ExistingReviewedAssignmentAdapter extends RecyclerView.Adapter<AssignmentViewHolder>{
        Context ctx;
        List<Assignment> list;

        public ExistingReviewedAssignmentAdapter (Context ctx, List<Assignment> list){
                this.ctx = ctx;
                this.list = list;
        }
@Override
public int getItemCount() {
        return list.size();
        }

@Override
public AssignmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(ctx);
    View v = inflater.inflate(R.layout.assignment_item, null);
    return new AssignmentViewHolder(v,ctx);
        }

@Override
public void onBindViewHolder(AssignmentViewHolder holder, int position) {
        Assignment as = list.get(position);
        holder.percentage.setText("80%");
        holder.id.setText("Assignment Id "+as.getId());
        holder.title.setText(as.getTitle());
        holder.stud.setText("No. of Students submitted "+as.getNo_students()+"");
        holder.date.setText(" Deadline: 24th July");
        }


}
