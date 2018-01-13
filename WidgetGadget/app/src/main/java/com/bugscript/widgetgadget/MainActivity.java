package com.bugscript.widgetgadget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.github:
                        Toast.makeText(MainActivity.this,"Github",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.google:
                        Toast.makeText(MainActivity.this,"Google",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.benz:
                        Toast.makeText(MainActivity.this,"Benz",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.apple:
                        Toast.makeText(MainActivity.this,"Apple",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.facebook:
                        Toast.makeText(MainActivity.this,"Facebook",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
