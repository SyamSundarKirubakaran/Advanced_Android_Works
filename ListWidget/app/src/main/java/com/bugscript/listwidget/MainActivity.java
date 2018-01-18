package com.bugscript.listwidget;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bugscript.listwidget.provider.ContractClass;
import com.bugscript.listwidget.services.ChangeContentsService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    public RadioGroup radioGroup;
    public Button button;
    public static int[] ing_numbers;
    public static int[] step_numbers;
    public static String [] dishNames;
    public static String [][] quantity;
    public static String [][] measure;
    public static String [][] ingredient;
    public static String [][] step_id;
    public static String [][] shortDescription;
    public static String [][] description;
    public static String [][] videoURL;
    public static String [][] thumbnailURL;
    public static String [] servings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        radioGroup=findViewById(R.id.radioGroup);
        radioGroup.check(R.id.nutella);

        Cursor sample=getContentResolver().query(ContractClass.nameClass.CONTENT_URI,
                null,
                null,
                null,
                null
        );
        sample.moveToNext();
        switch (sample.getString(sample.getColumnIndex(ContractClass.nameClass.COLUMN_INGRED_VALUE))){
            case "Nutella":
                radioGroup.check(R.id.nutella);
                break;
            case "Brownies":
                radioGroup.check(R.id.brownies);
                break;
            case "Yellow Cake":
                radioGroup.check(R.id.yellow);
                break;
            case "Cheese Cake":
                radioGroup.check(R.id.cheesecake);
                break;
        }

        getContentsFromJson();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.nutella:
                        ContentValues cv = new ContentValues();
                        cv.put(ContractClass.nameClass.COLUMN_INGRED_VALUE, "Nutella");
                        getContentResolver().update(Uri.parse(ContractClass.nameClass.CONTENT_URI+"/1"),cv,null,null);
                        WidgetList.sendRefreshBroadcast(MainActivity.this);
                        break;
                    case R.id.brownies:
                        ContentValues cb = new ContentValues();
                        cb.put(ContractClass.nameClass.COLUMN_INGRED_VALUE, "Brownies");
                        getContentResolver().update(Uri.parse(ContractClass.nameClass.CONTENT_URI+"/1"),cb,null,null);
                        WidgetList.sendRefreshBroadcast(MainActivity.this);
                        break;
                    case R.id.yellow:
                        ContentValues cz = new ContentValues();
                        cz.put(ContractClass.nameClass.COLUMN_INGRED_VALUE, "Yellow Cake");
                        getContentResolver().update(Uri.parse(ContractClass.nameClass.CONTENT_URI+"/1"),cz,null,null);
                        WidgetList.sendRefreshBroadcast(MainActivity.this);
                        break;
                    case R.id.cheesecake:
                        ContentValues cq = new ContentValues();
                        cq.put(ContractClass.nameClass.COLUMN_INGRED_VALUE, "Cheese Cake");
                        getContentResolver().update(Uri.parse(ContractClass.nameClass.CONTENT_URI+"/1"),cq,null,null);
                        WidgetList.sendRefreshBroadcast(MainActivity.this);
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
                Toast.makeText(MainActivity.this,sample.getString(sample.getColumnIndex(ContractClass.nameClass.COLUMN_INGRED_VALUE))+"",Toast.LENGTH_LONG).show();
            }
        });

        WidgetList.sendRefreshBroadcast(this);
    }

    private void getContentsFromJson()  {
        try {
            final JSONArray jsonArray = new JSONArray(loadJSONFromAssert());
            dishNames=new String[jsonArray.length()];
            servings=new String[jsonArray.length()];
            ing_numbers=new int[jsonArray.length()];
            step_numbers=new int[jsonArray.length()];
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jo=jsonArray.getJSONObject(i);
                dishNames[i]=jo.getString("name");
                servings[i]=jo.getString("servings");
                JSONArray jsonArray1=jo.getJSONArray("ingredients");
                ing_numbers[i]=jsonArray1.length();
                JSONArray jsonArray2=jo.getJSONArray("steps");
                step_numbers[i]=jsonArray2.length();
            }
            int max=ing_numbers[0];
            for(int i = 0; i < ing_numbers.length; i++)
                if(max < ing_numbers[i])
                    max = ing_numbers[i];
            quantity=new String[jsonArray.length()][max];
            measure=new String[jsonArray.length()][max];
            ingredient=new String[jsonArray.length()][max];
            max=step_numbers[0];
            for(int i = 0; i < step_numbers.length; i++)
                if(max < step_numbers[i])
                    max = step_numbers[i];
            step_id=new String[jsonArray.length()][max];
            shortDescription=new String[jsonArray.length()][max];
            description=new String[jsonArray.length()][max];
            videoURL=new String[jsonArray.length()][max];
            thumbnailURL=new String[jsonArray.length()][max];
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jo=jsonArray.getJSONObject(i);
                JSONArray jsonArray1=jo.getJSONArray("ingredients");
                for(int j=0;j<jsonArray1.length();j++){
                    JSONObject je=jsonArray1.getJSONObject(j);
                    quantity[i][j]=je.getString("quantity");
                    measure[i][j]=je.getString("measure");
                    ingredient[i][j]=je.getString("ingredient");
                }
                JSONArray jsonArray2=jo.getJSONArray("steps");
                for (int j=0;j<jsonArray2.length();j++){
                    JSONObject jw=jsonArray2.getJSONObject(j);
                    step_id[i][j]=jw.getString("id");
                    shortDescription[i][j]=jw.getString("shortDescription");
                    description[i][j]=jw.getString("description");
                    videoURL[i][j]=jw.getString("videoURL");
                    thumbnailURL[i][j]=jw.getString("thumbnailURL");
                }
            }
            ChangeContentsService.startChangingList(this);
//            ContentValues contentValues = new ContentValues();
//            for(int i=0;i<dishNames.length;i++){
//                for(int j=0;j<ingredient[i].length;j++){
//                    contentValues.put(ContractClass.nameClass.COLUMN_INGRED_KEY,i);
//                    contentValues.put(ContractClass.nameClass.COLUMN_INGRED_VALUE,ingredient[i][j]);
//                    contentValues.put(ContractClass.nameClass.COLUMN_INGRED_MEASURE,measure[i][j]);
//                    contentValues.put(ContractClass.nameClass.COLUMN_INGRED_QUANTITY,quantity[i][j]);
//                    getContentResolver().insert(ContractClass.nameClass.CONTENT_URI,contentValues);
//                }
//            }

        }catch (JSONException e){
            Toast.makeText(MainActivity.this,"JSON parsing Exception",Toast.LENGTH_SHORT).show();
        }
    }

    public String loadJSONFromAssert(){
        String json=null;
        try{
            InputStream inputStream=this.getAssets().open("baking.json");
            int size= inputStream.available();
            byte[] buffer=new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json=new String(buffer,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }

}
