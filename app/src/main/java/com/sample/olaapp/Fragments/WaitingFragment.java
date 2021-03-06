package com.sample.olaapp.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sample.olaapp.Model.Helper;
import com.sample.olaapp.R;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class WaitingFragment extends Fragment {


    public WaitingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_waiting, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(getActivity(), Helper.getStringSharedPreference("ACTIVE_DRIVER", getActivity()), Toast.LENGTH_LONG).show();
    }
}
