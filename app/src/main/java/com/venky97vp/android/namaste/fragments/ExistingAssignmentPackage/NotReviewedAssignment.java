package com.venky97vp.android.namaste.fragments.ExistingAssignmentPackage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.venky97vp.android.namaste.R;
import com.venky97vp.android.namaste.adapters.ExistingUnreviewedAssignmentAdapter;
import com.venky97vp.android.namaste.classes.Assignment;
import com.venky97vp.android.namaste.classes.Section;
import com.venky97vp.android.namaste.fragments.NewAssignment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NotReviewedAssignment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NotReviewedAssignment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotReviewedAssignment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String title;
    private int page;
    private RecyclerView recyclerView;
    private ExistingUnreviewedAssignmentAdapter adapter;
    private TextView heading;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public NotReviewedAssignment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotReviewedAssignment.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment newInstance(int page, String title) {
        Fragment fragmentFirst = new NotReviewedAssignment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("Inside assign frag", "Inside assign frag");
        View view = inflater.inflate(R.layout.fragment_not_reviewed_assignment, container, false);
//        TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
//        tvLabel.setText(page + " -- " + title);
        List<Assignment> assglist = getList();
        recyclerView = (RecyclerView) view.findViewById(R.id.stud_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        adapter = new ExistingUnreviewedAssignmentAdapter(getContext(), assglist);
        heading = (TextView) view.findViewById(R.id.heading);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    public List<Assignment> getList(){
        List<Assignment> list= new ArrayList<>();
        list.add(new Assignment("Algebra", 1, 20, new Section(10, 50)));
        list.add(new Assignment("Geometry", 1, 20, new Section(10, 50)));
        list.add(new Assignment("English", 1, 20, new Section(10, 50)));
        return list;
    }


}
