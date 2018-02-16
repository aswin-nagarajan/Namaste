package com.venky97vp.android.namaste.adapters.viewholders;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.venky97vp.android.namaste.R;
import com.venky97vp.android.namaste.classes.Forum;
import com.venky97vp.android.namaste.fragments.dialogfragment.AnswerDialogFragment;

/**
 * Created by venky on 06-09-2017.
 */

public class FirebasePostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private View mView;
    private Context mContext;
    private Activity activity;
    private Forum post;

    public FirebasePostViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindPost(Forum post, Activity activity) {
        this.activity = activity;
        this.post = post;
        TextView question = (TextView) mView.findViewById(R.id.forum_question);
        TextView questionExtended = (TextView) mView.findViewById(R.id.forum_question_extended);
        TextView uploader = (TextView) mView.findViewById(R.id.forum_uploader);
        Button answerButton = (Button) mView.findViewById(R.id.button_answer);

        if (post.answered) {
            answerButton.setText("Show Answer");
//            answer.setText(post.answer);
        } else {
            answerButton.setText("Answer");
        }

        answerButton.setOnClickListener(this);

//        Picasso.with(mContext)
//                .load(restaurant.getImageUrl())
//                .resize(MAX_WIDTH, MAX_HEIGHT)
//                .centerCrop()
//                .into(restaurantImageView);

//        title.setText(post.title);
        question.setText(post.question);
        uploader.setText(post.uploader);
        questionExtended.setText(post.questionExtended);
//        expand.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        final ArrayList<Post> posts = new ArrayList<>();
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("forum");
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    posts.add(snapshot.getValue(Post.class));
//                }
//
//                int itemPosition = getLayoutPosition();
//
////                Intent intent = new Intent(mContext, RestaurantDetailActivity.class);
////                intent.putExtra("position", itemPosition + "");
////                intent.putExtra("restaurants", Parcels.wrap(restaurants));
////
////                mContext.startActivity(intent);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });
        int id = view.getId();
        if (id == R.id.button_answer) {
            if (post != null) {
                AnswerDialogFragment df = new AnswerDialogFragment();
                Bundle args = new Bundle();
                args.putString("question", post.question);
                args.putString("question_ext", post.questionExtended);
                args.putString("question_id", post.id);
                args.putString("uploader", post.uploader);
                args.putString("category", post.category);
                args.putParcelableArrayList("answer_list", post.answer);
                df.setArguments(args);
                df.show(activity.getFragmentManager(), "AnswerDialog");
            }
        }
    }
}
