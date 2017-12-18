package com.venky97vp.android.namaste.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.listeners.GroupExpandCollapseListener;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.venky97vp.android.namaste.R;
import com.venky97vp.android.namaste.adapters.DaysAdapter;
import com.venky97vp.android.namaste.classes.timetable.TTDay;
import com.venky97vp.android.namaste.classes.timetable.TTHour;

import java.util.ArrayList;
import java.util.List;

public class TimetableFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private DaysAdapter adapter;

    public TimetableFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timetable, container, false);
        List<TTDay> days = getDays();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        adapter = new DaysAdapter(getContext(), days);


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private List<TTDay> getDays() {
        List<TTDay> list = new ArrayList<>();
        List<TTHour> hlist = new ArrayList<>();
        hlist.add(new TTHour("Math"));
        hlist.add(new TTHour("Science"));
        hlist.add(new TTHour("Social"));
        hlist.add(new TTHour("Lunch"));
        hlist.add(new TTHour("English"));
        hlist.add(new TTHour("P.E.T"));
        hlist.add(new TTHour("Language"));
        list.add(new TTDay("Monday", hlist));
        list.add(new TTDay("Tuesday", hlist));
        list.add(new TTDay("Wednesday", hlist));
        list.add(new TTDay("Thursday", hlist));
        list.add(new TTDay("Friday", hlist));
        list.add(new TTDay("Saturday", hlist));
        return list;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
