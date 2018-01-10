package com.bugscript.flexiblefragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentContents contents_1=new FragmentContents();
        FragmentManager fragmentManager=getSupportFragmentManager();

        contents_1.setmColors(0);
        fragmentManager.beginTransaction()
                .add(R.id.container_1,contents_1)
                .commit();


        FragmentContents contents_2=new FragmentContents();
        contents_2.setmColors(1);
        fragmentManager.beginTransaction()
                .add(R.id.container_2,contents_2)
                .commit();


        FragmentContents contents_3=new FragmentContents();
        contents_3.setmColors(2);
        fragmentManager.beginTransaction()
                .add(R.id.container_3,contents_3)
                .commit();

        FragmentContents contents_4=new FragmentContents();
        contents_4.setmColors(3);
        fragmentManager.beginTransaction()
                .add(R.id.container_4,contents_4)
                .commit();
    }
}
