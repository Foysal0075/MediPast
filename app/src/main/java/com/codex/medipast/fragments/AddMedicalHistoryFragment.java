package com.codex.medipast.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.codex.medipast.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddMedicalHistoryFragment extends Fragment {

    EditText addName, addDetails;
    Button addDate;
    ImageView prescriptionImageVIew;

    public AddMedicalHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_medical_history, container, false);

        addName = view.findViewById(R.id.medicalDoctorNameET);
        addDetails = view.findViewById(R.id.medicalDetailsET);
        addDate = view.findViewById(R.id.medicalDateET);
        prescriptionImageVIew = view.findViewById(R.id.prescription_image_view);


        return view;
    }

}
