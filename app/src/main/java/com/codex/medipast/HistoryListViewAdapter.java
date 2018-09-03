package com.codex.medipast;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HistoryListViewAdapter extends ArrayAdapter<MedicalHistory> {


    private Context context;
    private List<MedicalHistory> historyList = new ArrayList<>();

    public HistoryListViewAdapter(@NonNull Context context, List<MedicalHistory> medicalHistoryList) {
        super(context, R.layout.history_list_model,medicalHistoryList);

        this.context=context;
        this.historyList=medicalHistoryList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater= LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.history_list_model,parent,false);

        MedicalHistory medicalHistory = historyList.get(position);
        ImageView image=convertView.findViewById(R.id.history_list_imageView);
        TextView doctorName=convertView.findViewById(R.id.history_NameView);
        TextView doctorDetails=convertView.findViewById(R.id.history_doctor_name_view);
        TextView doctorDate=convertView.findViewById(R.id.doctor_history_date);

        Bitmap imageBitmap = decodeBase64(medicalHistory.getPrescriptionImageData());
        image.setImageBitmap(imageBitmap);
        doctorName.setText(medicalHistory.getVisitedDoctorName());
        doctorDetails.setText(medicalHistory.getMedicalDetails());
        doctorDate.setText(medicalHistory.getPrescriptionDate());

        return convertView;

    }

    public static Bitmap decodeBase64(String input)
    {
        byte[] decodedBytes = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }
}
