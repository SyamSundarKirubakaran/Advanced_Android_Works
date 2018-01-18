package com.bugscript.contentprovider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.BatchUpdateException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.insertData) EditText insertGotValue;
    @BindView(R.id.insertChecked) ImageView insertNow;
    @BindView(R.id.deleteChecked) ImageView deleteChecked;

    String[] mobileArray;
    String nameGot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        updateList();
        insertNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=insertGotValue.getText().toString().trim().toLowerCase();
                if(name.length()==0){
                    return;
                }
                ContentValues cv = new ContentValues();
                cv.put(ContractClass.nameClass.COLUMN_PERSON_NAME, name);
                Uri uri=getContentResolver().insert(ContractClass.nameClass.CONTENT_URI,cv);
                if(uri!=null){
                    Toast.makeText(getBaseContext(),uri.toString(),Toast.LENGTH_SHORT).show();
                    updateList();
                    insertGotValue.getText().clear();
                    insertGotValue.clearFocus();
                }
            }
        });

        deleteChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContentResolver().delete(ContractClass.nameClass.CONTENT_URI,null,null);
//                getContentResolver().delete(ContractClass.nameClass.CONTENT_URI,"_id=?", new String[]{"1"});
                updateList();
            }
        });


    }

    public void updateList(){

        Cursor cursor = getAllGuests();
        mobileArray=new String[cursor.getCount()];

        Toast.makeText(MainActivity.this,"No.of Rows:"+cursor.getCount(),Toast.LENGTH_SHORT).show();

        for(int i=0;i<cursor.getCount();i++){
            cursor.moveToNext();
            nameGot=cursor.getString(cursor.getColumnIndex(ContractClass.nameClass.COLUMN_PERSON_NAME));
            mobileArray[i]=nameGot;
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobileArray);

        ListView listView = findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);
    }

    private Cursor getAllGuests() {
        Cursor sample=getContentResolver().query(ContractClass.nameClass.CONTENT_URI,
                null,
                null,
                null,
                null
        );
        return sample;

    }
}
