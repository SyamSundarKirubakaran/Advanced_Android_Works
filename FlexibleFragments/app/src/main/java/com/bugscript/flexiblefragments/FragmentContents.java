package com.bugscript.flexiblefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by syamsundark on 10/01/18.
 */

public class FragmentContents extends Fragment {

    public int mColors = 0;
    public int mValue = 0;

    public FragmentContents() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_body, container, false);

        View colorChangingView=rootView.findViewById(R.id.view);

        switch (mColors){
            case 0:
                colorChangingView.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            case 1:
                colorChangingView.setBackgroundColor(getResources().getColor(R.color.violet));
                break;
            case 2:
                colorChangingView.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
        }

        return rootView;
    }

    public void setmColors(int color_number){
        mColors=color_number;
    }
    public void setmValue(int value_got){
        mValue=value_got;
    }
}
