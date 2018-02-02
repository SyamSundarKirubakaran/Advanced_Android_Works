package com.bugscript.androidanim;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view){
        ImageView imageView=findViewById(R.id.imageid);
        Intent intent=new Intent(this,second.class);
        ActivityOptionsCompat optionsCompat=ActivityOptionsCompat.makeSceneTransitionAnimation(this,imageView,"transitionname");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            startActivity(intent,optionsCompat.toBundle());
        }
    }
}
