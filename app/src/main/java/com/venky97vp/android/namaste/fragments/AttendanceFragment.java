package com.venky97vp.android.namaste.fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.venky97vp.android.namaste.R;
import com.venky97vp.android.namaste.adapters.AttendanceAdapter;
import com.venky97vp.android.namaste.adapters.AttendanceEntryViewHolder;
import com.venky97vp.android.namaste.classes.Presence;
import com.venky97vp.android.namaste.classes.Section;
import com.venky97vp.android.namaste.classes.Student;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class AttendanceFragment extends Fragment implements Button.OnClickListener{

    private Section ClassSelected;
    private EditText txtDate;
    private TextView name;
    private OnFragmentInteractionListener mListener;
    private int mYear, mMonth, mDay;
    private AttendanceAdapter adapter;
    private RecyclerView recyclerView;
    private String stringDate;
    private CharSequence text;
    private int duration;
    private Button upload;

    private DatabaseReference mDatabase;
    private DatabaseReference childRef;
    private DatabaseReference uploadRef;
// ...


    public AttendanceFragment() {
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
       View view =  inflater.inflate(R.layout.fragment_attendance, container, false);
        txtDate = (EditText) view.findViewById(R.id.edit_date);
        txtDate.setText("");
        final Calendar c = Calendar.getInstance();
        upload = (Button) view.findViewById(R.id.upload);
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        name = (TextView) view.findViewById(R.id.textView2);
        name.setText("Sasikala DK");
        mDatabase = FirebaseDatabase.getInstance().getReference();
        MaterialSpinner spinner = (MaterialSpinner)view.findViewById(R.id.spinner);
        ImageButton open_cal = (ImageButton) view.findViewById(R.id.cal_button);
        open_cal.setOnClickListener(this);
        spinner.setItems("11-A Biology", "12-B Physics", "12-C Chemistry", "11-B Maths");
        Context context = getContext();
        text = "Uploaded Successfully !";
        duration = Toast.LENGTH_SHORT;


        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {

            }
        });
        //recycler view
        List<Presence> studentsList = getList();
        recyclerView = (RecyclerView) view.findViewById(R.id.stud_recycler);
////        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        adapter = new AttendanceAdapter(getContext(), studentsList);
        childRef = mDatabase.child("sections")
                .child("10A")
                .child("students");
        adapter = new AttendanceAdapter(Student.class, R.layout.attendance_entry, AttendanceEntryViewHolder.class, childRef, getContext());

//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        upload.setOnClickListener(this);
        //recycler code end
        return view;
    }

    @Override
    public void onClick(View view) {

        if (view == upload) {
            if (TextUtils.isEmpty(txtDate.getText())) {
                text = "Date box is empty";
                Toast toast = Toast.makeText(getContext(), text, duration);
                toast.show();
            } else {
                mDatabase.child("attendance")
                        .child("10A")
                        .child(stringDate)
                        .setValue(adapter.getItemList());
                text = "Uploaded Successfully !";
                Toast toast = Toast.makeText(getContext(), text, duration);
                toast.show();
            }
        }else {
            openDatePicker();
        }

    }

    private List<Presence> getList() {
        List<Presence> hlist = new ArrayList<>();

//        hlist.add(new Presence(false, false, "1", "Aswin"));
//        hlist.add(new Presence(false, false, "2", "Dhilip"));
//        hlist.add(new Presence(false, false, "3", "Eniyavan"));
//        hlist.add(new Presence(false, false, "4", "Venkatesh"));
//        hlist.add(new Presence(false, false, "5", "Jithendran"));
//        hlist.add(new Presence(false, false, "6", "TestName"));
//        hlist.add(new Presence(false, false, "7", "Aswin"));
//        hlist.add(new Presence(false, false, "8", "Dhilip"));
//        hlist.add(new Presence(false, false, "9", "Eniyavan"));
//        hlist.add(new Presence(false, false, "10", "Venkatesh"));
//        hlist.add(new Presence(false, false, "11", "Jithendran"));
//        hlist.add(new Presence(false, false, "12", "TestName"));
//        hlist.add(new Presence(false, false, "14", "Aswin"));
//        hlist.add(new Presence(false, false, "15", "Dhilip"));
//        hlist.add(new Presence(false, false, "16", "Eniyavan"));
//        hlist.add(new Presence(false, false, "17", "Venkatesh"));
//        hlist.add(new Presence(false, false, "18", "Jithendran"));
//        hlist.add(new Presence(false, false, "19", "TestName"));
//        hlist.add(new Presence(false, false, "20", "Aswin"));
//        hlist.add(new Presence(false, false, "21", "Dhilip"));
//        hlist.add(new Presence(false, false, "22", "Eniyavan"));
//        hlist.add(new Presence(false, false, "23", "Venkatesh"));
//        hlist.add(new Presence(false, false, "24", "Jithendran"));
//        hlist.add(new Presence(false, false, "25", "TestName"));
        return hlist;
    }

    public void openDatePicker() {
        // Get Current Date
        final DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        txtDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        stringDate = dayOfMonth + "" +monthOfYear + year;

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
