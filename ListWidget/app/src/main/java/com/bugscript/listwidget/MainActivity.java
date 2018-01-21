package com.bugscript.listwidget;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bugscript.listwidget.Utilities.NetworkUtils;
import com.bugscript.listwidget.provider.ContractClass;
import com.bugscript.listwidget.services.ChangeTitleService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

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
    public static String universalSelection="0";
    private URL url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        radioGroup=findViewById(R.id.radioGroup);
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("ingrad_pref",0);
        final SharedPreferences.Editor editor=sharedPreferences.edit();


        switch (sharedPreferences.getInt("selection",0)){
            case 0:
                radioGroup.check(R.id.nutella);
                universalSelection="0";
                WidgetList.sendRefreshBroadcast(MainActivity.this);
                break;
            case 1:
                radioGroup.check(R.id.brownies);
                universalSelection="1";
                WidgetList.sendRefreshBroadcast(MainActivity.this);
                break;
            case 2:
                radioGroup.check(R.id.yellow);
                universalSelection="2";
                WidgetList.sendRefreshBroadcast(MainActivity.this);
                break;
            case 3:
                radioGroup.check(R.id.cheesecake);
                universalSelection="3";
                WidgetList.sendRefreshBroadcast(MainActivity.this);
                break;
        }

        try{
            url=new URL("https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json");
        }catch (Exception e){
            Toast.makeText(MainActivity.this,"URL not Recognized..",Toast.LENGTH_LONG).show();
        }
        new GetRecipies().execute(url);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.nutella:
                        universalSelection="0";
                        editor.putInt("selection",0);
                        editor.commit();
                        ChangeTitleService.startChanging(MainActivity.this);
                        WidgetList.sendRefreshBroadcast(MainActivity.this);
                        break;
                    case R.id.brownies:
                        universalSelection="1";
                        editor.putInt("selection",1);
                        editor.commit();
                        ChangeTitleService.startChanging(MainActivity.this);
                        WidgetList.sendRefreshBroadcast(MainActivity.this);
                        break;
                    case R.id.yellow:
                        universalSelection="2";
                        editor.putInt("selection",2);
                        editor.commit();
                        ChangeTitleService.startChanging(MainActivity.this);
                        WidgetList.sendRefreshBroadcast(MainActivity.this);
                        break;
                    case R.id.cheesecake:
                        universalSelection="3";
                        editor.putInt("selection",3);
                        editor.commit();
                        ChangeTitleService.startChanging(MainActivity.this);
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

    public class GetRecipies extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {
            URL searchUrl = urls[0];
            String Results = null;
            try{
                Results= NetworkUtils.getResponseFromHttpUrl(searchUrl);
                try {
                    final JSONArray jsonArray = new JSONArray(Results);
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
                }catch (JSONException e){
                    Log.d("Message","JSON Parsing Exception");
                }
            }catch (IOException e){
                Log.d("Message","IO Network Exception");
            }
            return Results;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

}
