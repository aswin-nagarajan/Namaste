package com.venky97vp.android.namaste.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ExpandableListView;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.venky97vp.android.namaste.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GradeSheetFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private com.venky97vp.android.namaste.adapters.ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;

    public GradeSheetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grade_sheet, container, false);
        MaterialSpinner spinner = (MaterialSpinner) view.findViewById(R.id.spinner);
        spinner.setItems("12-D Biology", "11-A Biology", "10-C EVS");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {

            }
        });
        ExpandableListView expandableListView = (ExpandableListView) view.findViewById(R.id.elv1);
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        listDataHeader.add("A");
        listDataHeader.add("B");
        listDataHeader.add("C");
        List<String> A = new ArrayList<String>();
        A.add("Anand");
        A.add("Aswin");
        A.add("Athul");

        List<String> B = new ArrayList<String>();
        B.add("Badri");
        B.add("Balu");
        B.add("Benjamin");

        List<String> C = new ArrayList<String>();
        C.add("Cameroon");
        C.add("Chandrashekhar");
        C.add("Charles");

        listDataChild.put(listDataHeader.get(0), A); // Header, Child data
        listDataChild.put(listDataHeader.get(1), B);
        listDataChild.put(listDataHeader.get(2), C);
        listAdapter = new com.venky97vp.android.namaste.adapters.ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);
        expandableListView.setAdapter(listAdapter);
        return view;
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
