package com.bugscript.flexiblefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by syamsundark on 10/01/18.
 */

public class LandscapeContents extends Fragment {

    private static int mLabel=0;

    public LandscapeContents() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_landscape, container, false);
        TextView landscape_text=rootView.findViewById(R.id.textView2);
        View mainView=rootView.findViewById(R.id.land_id);
        switch (mLabel){
            case 0:
                mainView.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            case 1:
                mainView.setBackgroundColor(getResources().getColor(R.color.violet));
                break;
            case 2:
                mainView.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
            case 3:
                mainView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }
        landscape_text.setText("Communication from Fragment #"+mLabel);
        return rootView;
    }

    public void mSetLabel(int label){mLabel=label;}

}
