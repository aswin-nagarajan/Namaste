package com.venky97vp.android.namaste.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.venky97vp.android.namaste.R;
import com.venky97vp.android.namaste.classes.AssignmentQuestion;

import java.util.List;

/**
 * Created by Aswin Nagarajan on 15-02-2018.
 */

public class NewAssignmentAdapter extends RecyclerView.Adapter<QuestionViewHolder>{

    Context ctx;
    List<AssignmentQuestion> list;
    @Override
    public int getItemCount() {
        return list.size();
    }

    public NewAssignmentAdapter(Context ctx, List<AssignmentQuestion> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(R.layout.assignment_question, null);
        return new QuestionViewHolder(v,ctx);
    }

    @Override
    public void onBindViewHolder(QuestionViewHolder holder, int position) {
        AssignmentQuestion as = list.get(position);
        holder.id.setText(as.getId());

    }
}
