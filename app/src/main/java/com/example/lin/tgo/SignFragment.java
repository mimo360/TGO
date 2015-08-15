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

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignFragment extends Fragment {
    EditText signname, signpass, signtel, signaddress;


    public SignFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign, container, false);



    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        signname =(EditText)getView().findViewById(R.id.signname);
        signpass = (EditText)getView().findViewById(R.id.signpass);
        signtel = (EditText)getView().findViewById(R.id.signtel);
        signaddress = (EditText)getView().findViewById(R.id.signaddress);
        Button button = (Button)getView().findViewById(R.id.signbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser parseUser = new ParseUser();
                parseUser.setUsername(signname.getText().toString());
                parseUser.setPassword(signpass.getText().toString());
                parseUser.put("tel", signtel.getText().toString());
                parseUser.put("address", signaddress.getText().toString());
                parseUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        Toast.makeText(getActivity(),"註冊成功",Toast.LENGTH_LONG).show();
                        FragmentManager fm = getFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        LogFragment logFragment = new LogFragment();
                        ft.replace(R.id.framelayout,logFragment);
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                });
            }
        });

    }
}
