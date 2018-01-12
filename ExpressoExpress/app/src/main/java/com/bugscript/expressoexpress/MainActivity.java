package com.bugscript.expressoexpress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView) TextView mNumber;
    public static int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.imageView)
    public void performActionAdd(){
        if(i>8){

        }else {
            i += 1;
            mNumber.setText(i+"");
        }
    }

    @OnClick(R.id.imageView2)
    public void performActionSub(){
        if(i<1){

        }else {
            i -= 1;
            mNumber.setText(i+"");
        }
    }

    @OnClick(R.id.button)
    public void transition(){
        Intent s=new Intent(MainActivity.this,SecondActivity.class);
        s.putExtra("number",i);
        startActivity(s);
    }
}
