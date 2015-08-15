package com.example.lin.tgo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    LogFragment logFragment = null;
    public static List<ParseObject> find = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.initialize(this, "GGtET1gfeRFGu6BhW8OEhP6nLb9nZ79maJDaxXrE", "0rLkRTr7RVt58nVe9GUOFTemVCR2cqiHRqFGI3iS");
        logFragment = new LogFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction  ft = fm.beginTransaction();
        ft.add(R.id.framelayout, logFragment, "LogFragment");
        ft.commit();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("item");
                try {
                    find = parseQuery.find();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
