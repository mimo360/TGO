package com.example.lin.tgo;


import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {
    Spinner spinneritem;
    List<String> list= new ArrayList<>();
    int so = 1;

    public OrderFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        for(ParseObject p : MainActivity.find){
            list.add(p.getString("name"));
        }

        spinneritem = (Spinner)getView().findViewById(R.id.spinneritem);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.myspinner,list);
        adapter.setDropDownViewResource(R.layout.myspinner);
        spinneritem.setAdapter(adapter);

        SeekBar seekBar = (SeekBar)getView().findViewById(R.id.seekBar);
        seekBar.setMax(100);










    }
}
