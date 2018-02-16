package com.venky97vp.android.namaste.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.venky97vp.android.namaste.ForumEntryActivity;
import com.venky97vp.android.namaste.R;
import com.venky97vp.android.namaste.adapters.viewholders.FirebasePostViewHolder;
import com.venky97vp.android.namaste.classes.Forum;


public class ForumFragment extends Fragment implements View.OnClickListener {

    private DatabaseReference mDatabase;
    FirebaseDatabase database;
    FirebaseRecyclerAdapter mAdapter;
    FloatingActionButton createPost;
    private ProgressBar loader;

    public ForumFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView forumRecycler = (RecyclerView) view.findViewById(R.id.recycler_forum);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        createPost = (FloatingActionButton) view.findViewById(R.id.button_create_post);
        loader = (ProgressBar) view.findViewById(R.id.forum_progress);
        loader.setVisibility(View.VISIBLE);
        createPost.setOnClickListener(this);
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference();
        mAdapter = new FirebaseRecyclerAdapter<Forum, FirebasePostViewHolder>
                (Forum.class, R.layout.each_forum, FirebasePostViewHolder.class, mDatabase.child("forums")) {

            @Override
            protected void populateViewHolder(FirebasePostViewHolder viewHolder, Forum model, int position) {
                viewHolder.bindPost(model, getActivity());
                loader.setVisibility(View.GONE);
            }
        };

        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // the initial data is loaded (even if there was none)
                loader.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                loader.setVisibility(View.GONE);
            }
        });

        forumRecycler.setItemAnimator(new DefaultItemAnimator());
        forumRecycler.setLayoutManager(mLayoutManager);
        forumRecycler.setAdapter(mAdapter);
        forumRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0)
                    createPost.hide();
                else if (dy < 0)
                    createPost.show();
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_create_post) {
            Intent intent = new Intent(getContext(), ForumEntryActivity.class);
            startActivity(intent);
        }
    }
}
