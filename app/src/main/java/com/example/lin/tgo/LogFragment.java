package com.example.lin.tgo;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class LogFragment extends Fragment {


    public LogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button btSign = (Button)getView().findViewById(R.id.button);
        btSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignFragment signFragment = new SignFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.framelayout,signFragment,"SignFragment");
               // ft.addToBackStack(null);
                ft.commit();
            }
        });
        Button btsignin = (Button)getView().findViewById(R.id.signin);
        btsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etlogname = (EditText)getView().findViewById(R.id.etlogname);
                EditText etlogpass = (EditText)getView().findViewById(R.id.etlogpass);
                ParseUser parseUser = new ParseUser();
                parseUser.logInInBackground(etlogname.getText().toString(), etlogpass.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if (e == null){
                            FragmentManager fm = getFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            OrderFragment orderFragment = new OrderFragment();
                            ft.replace(R.id.framelayout,orderFragment,"OrderFragment");
                            ft.addToBackStack(null);
                            ft.commit();

                        }else {
                            Toast.makeText(getActivity(),"請檢查帳號密",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}
