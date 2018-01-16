package com.bugscript.listwidget.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.bugscript.listwidget.MainActivity;

/**
 * Created by syamsundark on 16/01/18.
 */

public class ChangeContentsService extends IntentService {


    private static final String TAG = "Service Log";

    public ChangeContentsService() {
        super("ChangeContentsService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (MainActivity.ACTION_CONVERT_LIST.equals(action)) {
                Log.v(TAG, "handler Reached successfully..");
            }
        }
    }
}
