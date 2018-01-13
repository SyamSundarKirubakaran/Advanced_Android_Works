package com.bugscript.contentprovider;

import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.insertData) EditText insertGotValue;
    @BindView(R.id.insertChecked) ImageView insertNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        insertNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=insertGotValue.getText().toString().trim();
                if(name.length()==0){
                    return;
                }
                ContentValues cv = new ContentValues();
                cv.put(ContractClass.nameClass.COLUMN_PERSON_NAME, name);
                Uri uri=getContentResolver().insert(ContractClass.nameClass.CONTENT_URI,cv);
                if(uri!=null){
                    Toast.makeText(getBaseContext(),uri.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
