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
import com.bugscript.widgetgadget.services.ChangeImageService;

public class MainActivity extends AppCompatActivity {

    public RadioGroup radioGroup;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        radioGroup=findViewById(R.id.radioGroup);

//        DO THIS ONLY ONCE FOR INIT VALUE OF _ID = 1
//        ContentValues cv = new ContentValues();
//        cv.put(ContractClass.nameClass.COLUMN_PERSON_NAME, 1);
//        Uri uri=getContentResolver().insert(ContractClass.nameClass.CONTENT_URI,cv);

        Cursor cursor=getContentResolver().query(ContractClass.nameClass.CONTENT_URI,
                null,
                null,
                null,
                null
        );
        cursor.moveToNext();
        switch (cursor.getInt(cursor.getColumnIndex(ContractClass.nameClass.COLUMN_PERSON_NAME))){
            case 1:
                radioGroup.check(R.id.github);
                break;
            case 2:
                radioGroup.check(R.id.google);
                break;
            case 3:
                radioGroup.check(R.id.benz);
                break;
            case 4:
                radioGroup.check(R.id.apple);
                break;
            case 5:
                radioGroup.check(R.id.facebook);
                break;
            default:
                Toast.makeText(MainActivity.this,"Unable to make Check",Toast.LENGTH_LONG).show();
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.github:
                        ContentValues cv = new ContentValues();
                        cv.put(ContractClass.nameClass.COLUMN_PERSON_NAME, 1);
                        getContentResolver().update(Uri.parse(ContractClass.nameClass.CONTENT_URI+"/1"),cv,null,null);
                        ChangeImageService.startChangingImage(MainActivity.this);
                        break;
                    case R.id.google:
                        ContentValues cp = new ContentValues();
                        cp.put(ContractClass.nameClass.COLUMN_PERSON_NAME, 2);
                        getContentResolver().update(Uri.parse(ContractClass.nameClass.CONTENT_URI+"/1"),cp,null,null);
                        ChangeImageService.startChangingImage(MainActivity.this);
                        break;
                    case R.id.benz:
                        ContentValues ca = new ContentValues();
                        ca.put(ContractClass.nameClass.COLUMN_PERSON_NAME, 3);
                        getContentResolver().update(Uri.parse(ContractClass.nameClass.CONTENT_URI+"/1"),ca,null,null);
                        ChangeImageService.startChangingImage(MainActivity.this);
                        break;
                    case R.id.apple:
                        ContentValues cb = new ContentValues();
                        cb.put(ContractClass.nameClass.COLUMN_PERSON_NAME, 4);
                        getContentResolver().update(Uri.parse(ContractClass.nameClass.CONTENT_URI+"/1"),cb,null,null);
                        ChangeImageService.startChangingImage(MainActivity.this);
                        break;
                    case R.id.facebook:
                        ContentValues cc = new ContentValues();
                        cc.put(ContractClass.nameClass.COLUMN_PERSON_NAME, 5);
                        getContentResolver().update(Uri.parse(ContractClass.nameClass.CONTENT_URI+"/1"),cc,null,null);
                        ChangeImageService.startChangingImage(MainActivity.this);
                        break;
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
