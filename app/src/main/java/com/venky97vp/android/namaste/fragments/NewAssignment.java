package com.venky97vp.android.namaste.fragments;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.venky97vp.android.namaste.R;
import com.venky97vp.android.namaste.adapters.AttendanceAdapter;
import com.venky97vp.android.namaste.adapters.NewAssignmentAdapter;
import com.venky97vp.android.namaste.classes.AssignmentQuestion;
import com.venky97vp.android.namaste.classes.Presence;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Aswin Nagarajan on 15-02-2018.
 */

public class NewAssignment extends Fragment implements Button.OnClickListener {

    // Store instance variables
    private String title;
    private int page;
    private int mYear, mMonth, mDay;
    private EditText txtDate;
    private RecyclerView recyclerView;
    private NewAssignmentAdapter adapter;

    // newInstance constructor for creating fragment with arguments
    public static Fragment newInstance(int page, String title) {
        Fragment fragmentFirst = new NewAssignment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_assgt_frag, container, false);
//        TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
//        tvLabel.setText(page + " -- " +
        List<AssignmentQuestion> studentsList = getList();
        recyclerView = (RecyclerView) view.findViewById(R.id.stud_recycler);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        adapter = new NewAssignmentAdapter(getContext(), studentsList);
        MaterialSpinner spinner = (MaterialSpinner)view.findViewById(R.id.spinner);
        spinner.setItems("11-A Biology", "12-B Physics", "12-C Chemistry", "11-B Maths");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {

            }
        });

//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        txtDate = (EditText) view.findViewById(R.id.edit_date);
        ImageButton open_cal = (ImageButton) view.findViewById(R.id.cal_button);
        open_cal.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        openDatePicker();
    }

    private List<AssignmentQuestion> getList() {
        List<AssignmentQuestion> list = new ArrayList<>();
        list.add(new AssignmentQuestion("1"));
        list.add(new AssignmentQuestion("2"));
        list.add(new AssignmentQuestion("3"));
        return list;
    }

    public void openDatePicker() {
        // Get Current Date
        final DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        txtDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                    }
                }, mYear, mMonth, mDay);

        // get the date from TextView
        String startDate = txtDate.getText().toString();
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        try {
            date = simpleDateFormat.parse(startDate); // parse the String according to the desired format

        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        // set the date as minDate
        datePickerDialog.getDatePicker().setMinDate(date.getTime());
        datePickerDialog.show();
    }
}

