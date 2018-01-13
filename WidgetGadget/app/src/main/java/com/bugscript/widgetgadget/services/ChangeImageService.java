package com.bugscript.widgetgadget.services;

import android.app.IntentService;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.bugscript.widgetgadget.HelloWidget;
import com.bugscript.widgetgadget.MainActivity;
import com.bugscript.widgetgadget.provider.ContractClass;

/**
 * Created by syamsundark on 13/01/18.
 */

public class ChangeImageService extends IntentService {

    public static final String ACTION_WATER_PLANTS = "com.bugscript.widgetgadget.services.action.changeimageresource";

    public ChangeImageService() {
        super("ChangeImageService");
    }

    public static void startChangingImage(Context context){
        Intent intent = new Intent(context, ChangeImageService.class);
        intent.setAction(ACTION_WATER_PLANTS);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_WATER_PLANTS.equals(action)) {
                updateWidget();
            }
        }
    }

    private void updateWidget() {
        Cursor sample = getContentResolver().query(ContractClass.nameClass.CONTENT_URI,
                null,
                null,
                null,
                null
        );
        sample.moveToNext();
        int img=sample.getInt(sample.getColumnIndex(ContractClass.nameClass.COLUMN_PERSON_NAME));
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this, HelloWidget.class));
        HelloWidget.updateWidgetImage(this,appWidgetManager,img,appWidgetIds);
    }
}
