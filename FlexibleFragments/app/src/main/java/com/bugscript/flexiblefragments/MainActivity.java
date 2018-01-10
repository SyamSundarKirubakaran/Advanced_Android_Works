package com.bugscript.flexiblefragments;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            FragmentContents contents_1 = new FragmentContents();
            FragmentManager fragmentManager = getSupportFragmentManager();

            contents_1.setmColors(0);
            contents_1.setmValue(0);
            fragmentManager.beginTransaction()
                    .add(R.id.container_1, contents_1)
                    .commit();

            FrameLayout frameLayout2=findViewById(R.id.container_2);
            FrameLayout frameLayout3=findViewById(R.id.container_3);
            FrameLayout frameLayout4=findViewById(R.id.container_4);
            frameLayout2.setVisibility(View.GONE);
            frameLayout3.setVisibility(View.GONE);
            frameLayout4.setVisibility(View.GONE);

        }else{
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
}
