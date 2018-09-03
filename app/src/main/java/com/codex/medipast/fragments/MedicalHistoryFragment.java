package com.codex.medipast.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.codex.medipast.DbManager;
import com.codex.medipast.HistoryListViewAdapter;
import com.codex.medipast.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MedicalHistoryFragment extends Fragment {

    ListView listView;
    DbManager dbManager;

    public MedicalHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_medical_history, container, false);


        dbManager = new DbManager(getContext());
        listView = view.findViewById(R.id.history_list);
        HistoryListViewAdapter historyListViewAdapter = new HistoryListViewAdapter(getContext(),dbManager.getAllhistories());
        listView.setAdapter(historyListViewAdapter);
        return view;
    }

}
