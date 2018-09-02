package com.codex.medipast.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.codex.medipast.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddDoctorFragment extends Fragment {
    EditText addName, addDetails, addEmail, addPhones;
    TextView appointmentDate;
    Button addDoctor;


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


        return view;
    }

}
