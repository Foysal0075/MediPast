package com.codex.medipast.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.codex.medipast.DbManager;
import com.codex.medipast.DoctorViewAdapter;
import com.codex.medipast.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    ListView listView;
    DbManager dbManager;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        listView = view.findViewById(R.id.doctor_list_view);



        dbManager= new DbManager(getContext());
        DoctorViewAdapter adapter = new DoctorViewAdapter(getContext(),dbManager.getAllDoctors());
        listView.setAdapter(adapter);
        return view;
    }

}
