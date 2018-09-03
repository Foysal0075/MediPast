package com.codex.medipast.fragments;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.codex.medipast.DbManager;
import com.codex.medipast.Doctor;
import com.codex.medipast.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddDoctorFragment extends Fragment {
    EditText addName, addDetails, addEmail, addPhones;
    TextView appointmentDate;
    Button addDoctor;
    private DatePickerDialog datePickerDialog;
    DbManager dbManager;

    String currentDate;
    Calendar calendar = Calendar.getInstance();


    public AddDoctorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_doctor, container, false);

        addName = view.findViewById(R.id.doctorNameET);
        addDetails = view.findViewById(R.id.doctorDetailsET);
        addEmail = view.findViewById(R.id.doctorEmailET);
        addPhones = view.findViewById(R.id.doctorPhoneET);
        addDoctor = view.findViewById(R.id.addDoctorInfoButton);
        appointmentDate = view.findViewById(R.id.appointmentET);

        dbManager = new DbManager(getContext());


        appointmentDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Toast.makeText(getContext(), "Date Selected :"+dayOfMonth+":"+month+":"+year, Toast.LENGTH_SHORT).show();
                        currentDate = +dayOfMonth+"/"+month+"/"+year;
                        appointmentDate.setText(currentDate);
                    }
                },calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        addDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Doctor doctor = new Doctor(addName.getText().toString(),addDetails.getText().toString(),currentDate,addPhones.getText().toString(),addEmail.getText().toString());
                boolean isInserted = dbManager.addToDoctor(doctor);
                if (isInserted){
                   Toast.makeText(getActivity(),"Insertion Successful",Toast.LENGTH_SHORT).show();
                }

            }
        });


        return view;
    }

}
