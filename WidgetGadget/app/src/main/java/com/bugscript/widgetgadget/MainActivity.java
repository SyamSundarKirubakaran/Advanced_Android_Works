package com.bugscript.widgetgadget;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bugscript.widgetgadget.provider.ContractClass;

public class MainActivity extends AppCompatActivity {

    public RadioGroup radioGroup;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        radioGroup=findViewById(R.id.radioGroup);
        radioGroup.check(R.id.github);
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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues cv = new ContentValues();
                cv.put(ContractClass.nameClass.COLUMN_PERSON_NAME, 1);
                int result=getContentResolver().update(Uri.parse(ContractClass.nameClass.CONTENT_URI+"/1"),cv,null,null);
                if(result>0){
                    Toast.makeText(MainActivity.this,"Content Updated..",Toast.LENGTH_LONG).show();
                }

                Cursor sample=getContentResolver().query(ContractClass.nameClass.CONTENT_URI,
                        null,
                        null,
                        null,
                        null
                );
                sample.moveToNext();
                Toast.makeText(MainActivity.this,sample.getInt(sample.getColumnIndex(ContractClass.nameClass.COLUMN_PERSON_NAME))+"",Toast.LENGTH_LONG).show();
            }
        });
    }
}
