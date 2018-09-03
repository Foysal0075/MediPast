package com.codex.medipast;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DoctorViewAdapter extends ArrayAdapter<Doctor>{

    private Context context;
    private List<Doctor> doctorList = new ArrayList<>();

    public DoctorViewAdapter(@NonNull Context context, List<Doctor> doctorList) {

        super(context,R.layout.doctor_list_model,doctorList);
        this.context=context;
        this.doctorList=doctorList;
  }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.doctor_list_model,parent,false);

        Doctor doctor= doctorList.get(position);
        TextView doctorName=convertView.findViewById(R.id.doctorNameView);
        TextView doctorDetails=convertView.findViewById(R.id.doctorDetailsView);

        doctorName.setText(doctor.getDoctorName());
        doctorDetails.setText(doctor.getDoctordetails());

        return convertView;

    }
}
