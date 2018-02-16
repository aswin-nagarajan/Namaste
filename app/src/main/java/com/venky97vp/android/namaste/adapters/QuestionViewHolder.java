package com.venky97vp.android.namaste.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.venky97vp.android.namaste.R;

/**
 * Created by Aswin Nagarajan on 15-02-2018.
 */

public class QuestionViewHolder extends RecyclerView.ViewHolder {

    Context ctx;
    TextView id;
    ImageButton attach, cam, option;
    EditText question;
    public QuestionViewHolder(View itemView, Context ctx) {
        super(itemView);
        id = (TextView) itemView.findViewById(R.id.id);
        attach = (ImageButton) itemView.findViewById(R.id.attach);
        cam = (ImageButton) itemView.findViewById(R.id.cam);
        option = (ImageButton) itemView.findViewById(R.id.options);
        question = (EditText) itemView.findViewById(R.id.question);

        this.ctx = ctx;
    }
}
