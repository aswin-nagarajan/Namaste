package com.venky97vp.android.namaste.fragments.dialogfragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.venky97vp.android.namaste.R;
import com.venky97vp.android.namaste.adapters.AnswerRecyclerAdapter;
import com.venky97vp.android.namaste.classes.Answer;
import com.venky97vp.android.namaste.classes.Forum;
import com.venky97vp.android.namaste.utilities.Utilities;

import java.util.ArrayList;
import java.util.UUID;

import static android.content.ContentValues.TAG;


/**
 * Created by venky on 23-09-2017.
 */

public class AnswerDialogFragment extends DialogFragment implements View.OnClickListener {

    Forum post;
    TextView question, questionExt, uploader;
    EditText answerEdit;
    Button submit;
    ImageButton close;
    private RecyclerView answerRecycler;
    private AnswerRecyclerAdapter adapter;

    public AnswerDialogFragment() {
    }

//    public static AnswerDialogFragment newInstance(String title) {
//        AnswerDialogFragment frag = new AnswerDialogFragment();
//        Bundle args = new Bundle();
//        args.putString("title", title);
//        frag.setArguments(args);
//        return frag;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        post = new Forum();
        post.question = getArguments().getString("question");
        post.questionExtended = getArguments().getString("question_ext");
        post.uploader = getArguments().getString("uploader");
        post.category = getArguments().getString("category");
        post.id = getArguments().getString("question_id");
        post.answer = getArguments().getParcelableArrayList("answer_list");
        if (post.answer == null) {
            post.answer = new ArrayList<>();
        }
        Log.d(TAG, "onCreate: " + post.answer);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_answer_dialog, container);
        question = (TextView) view.findViewById(R.id.question);
        questionExt = (TextView) view.findViewById(R.id.question_extended);
        answerEdit = (EditText) view.findViewById(R.id.answer_enter);
        submit = (Button) view.findViewById(R.id.button_answer);
        close = (ImageButton) view.findViewById(R.id.button_close_dialog);
        uploader = (TextView) view.findViewById(R.id.uploader);

        answerRecycler = (RecyclerView) view.findViewById(R.id.recycler_answer);

        adapter = new AnswerRecyclerAdapter(getActivity(), post.answer);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        answerRecycler.setLayoutManager(mLayoutManager);
        answerRecycler.setNestedScrollingEnabled(false);
        answerRecycler.setItemAnimator(new DefaultItemAnimator());
        answerRecycler.setAdapter(adapter);

        submit.setOnClickListener(this);
        close.setOnClickListener(this);

        if (post != null) {
            question.setText(post.question);
            questionExt.setText(post.questionExtended);
            uploader.setText(post.uploader);
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_answer) {
            if (!Utilities.isEmptyOrNull(answerEdit.getText().toString())) {
                updateAnswer();
            }
        } else {
            this.dismiss();
        }
    }

    private void updateAnswer() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mDatabase = database.getReference();
        FirebaseAuth auth = FirebaseAuth.getInstance();

        post.answered = true;
        post.answer.add(new Answer(UUID.randomUUID().toString(), answerEdit.getText().toString(), auth.getCurrentUser().getEmail()));

        if (post != null) {
            mDatabase.child("forums")
                    .child(post.id)
                    .setValue(post);
        }
        adapter.notifyDataSetChanged();
        answerEdit.setText("");
    }
}
