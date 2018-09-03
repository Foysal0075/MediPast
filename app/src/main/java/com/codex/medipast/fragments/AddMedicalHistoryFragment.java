package com.codex.medipast.fragments;


import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.codex.medipast.DbManager;
import com.codex.medipast.MedicalHistory;
import com.codex.medipast.R;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddMedicalHistoryFragment extends Fragment {

   private EditText addName, addDetails;
   private TextView addDate;
   private ImageView prescriptionImageVIew;
   private DatePickerDialog datePickerDialog;
   private String currentDate;
   private Calendar calendar =Calendar.getInstance();
   private String mPhotoData;
   private Button takePictureButton,addHistoryButton;
   private DbManager dbManager;

    static final  int REQUEST_IMAGE_CAPTURE=1;
    static final  int CAMERA_REQUEST_CODE=1;

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
        takePictureButton = view.findViewById(R.id.takePrescriptionButton);
        addHistoryButton = view.findViewById(R.id.medicalAddHistoryButton);
        dbManager = new DbManager(getContext());

        getCameraPermission();

        addDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Toast.makeText(getActivity(), "Date Selected :"+dayOfMonth+":"+month+":"+year, Toast.LENGTH_SHORT).show();
                        currentDate = +dayOfMonth+"/"+month+"/"+year;
                        addDate.setText(currentDate);
                    }
                },calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        takePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });

        addHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MedicalHistory history = new MedicalHistory(mPhotoData,addName.getText().toString(),addDetails.getText().toString(),addDate.getText().toString());
                boolean isInserted = dbManager.addToHistory(history);
                if (isInserted){
                    Toast.makeText(getContext(), "Successfull", Toast.LENGTH_SHORT).show();
                }
            }
        });



        return view;
    }


    public void getCameraPermission(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if (getActivity().checkSelfPermission(Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[]{Manifest.permission.CAMERA},CAMERA_REQUEST_CODE);
            }
        }
    }

    public void takePicture(){
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (cameraIntent.resolveActivity(getActivity().getPackageManager())!=null){
            startActivityForResult(cameraIntent,REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

     if (requestCode==REQUEST_IMAGE_CAPTURE && resultCode==RESULT_OK){

         Bundle extras = data.getExtras();
         Bitmap imageBitmap = (Bitmap) extras.get("data");
         mPhotoData = encodeToBase64 (imageBitmap,Bitmap.CompressFormat.JPEG, 50);
         System.out.println(mPhotoData);
         prescriptionImageVIew.setImageBitmap(imageBitmap);
     }
     }

    public static String encodeToBase64(Bitmap image, Bitmap.CompressFormat compressFormat, int quality)
    {
        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        image.compress(compressFormat, quality, byteArrayOS);
        return Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT);
    }


    public static Bitmap decodeBase64(String input)
    {
        byte[] decodedBytes = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }


}
