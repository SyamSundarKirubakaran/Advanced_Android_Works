package com.bugscript.flexiblefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by syamsundark on 11/01/18.
 */

public class Activity2Main extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2_fragment);
        int index=getIntent().getExtras().getInt("index");
        LandscapeContents landscapeContents=new LandscapeContents();
        landscapeContents.mSetLabel(index);
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.activity_2_fragment_layout, landscapeContents)
                .commit();
    }
}
