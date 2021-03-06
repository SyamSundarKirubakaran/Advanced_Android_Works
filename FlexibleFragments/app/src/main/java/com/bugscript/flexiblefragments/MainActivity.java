package com.bugscript.flexiblefragments;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  FragmentContents.OnFragmentClickListener{

    public Button button;
    public static int final_position=0;
    public static boolean tabletSize=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabletSize = getResources().getBoolean(R.bool.isTablet);
        if (tabletSize) {
            FragmentContents contents_1 = new FragmentContents();
            FragmentManager fragmentManager = getSupportFragmentManager();

            contents_1.setmColors(0);
            contents_1.setmValue(0);
            fragmentManager.beginTransaction()
                    .add(R.id.container_1, contents_1)
                    .commit();


            FragmentContents contents_2 = new FragmentContents();
            contents_2.setmColors(1);
            contents_2.setmValue(1);
            fragmentManager.beginTransaction()
                    .add(R.id.container_2, contents_2)
                    .commit();


            FragmentContents contents_3 = new FragmentContents();
            contents_3.setmColors(2);
            contents_3.setmValue(2);
            fragmentManager.beginTransaction()
                    .add(R.id.container_3, contents_3)
                    .commit();

            FragmentContents contents_4 = new FragmentContents();
            contents_4.setmColors(3);
            contents_4.setmValue(3);
            fragmentManager.beginTransaction()
                    .add(R.id.container_4, contents_4)
                    .commit();

        } else {
            FragmentContents contents_1 = new FragmentContents();
            FragmentManager fragmentManager = getSupportFragmentManager();

            contents_1.setmColors(0);
            contents_1.setmValue(0);
            fragmentManager.beginTransaction()
                    .add(R.id.container_1, contents_1)
                    .commit();


            FragmentContents contents_2 = new FragmentContents();
            contents_2.setmColors(1);
            contents_2.setmValue(1);
            fragmentManager.beginTransaction()
                    .add(R.id.container_2, contents_2)
                    .commit();


            FragmentContents contents_3 = new FragmentContents();
            contents_3.setmColors(2);
            contents_3.setmValue(2);
            fragmentManager.beginTransaction()
                    .add(R.id.container_3, contents_3)
                    .commit();

            FragmentContents contents_4 = new FragmentContents();
            contents_4.setmColors(3);
            contents_4.setmValue(3);
            fragmentManager.beginTransaction()
                    .add(R.id.container_4, contents_4)
                    .commit();
        }
    }

    @Override
    public void onFragmentSelected(int position) {
        if(tabletSize){
            LandscapeContents landscapeContents=new LandscapeContents();
            landscapeContents.mSetLabel(position);
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.activity_2_fragment_layout, landscapeContents)
                    .commit();
        }else {
            Intent i = new Intent(MainActivity.this, Activity2Main.class);
            final_position=position;
            startActivity(i);
        }
    }
}
