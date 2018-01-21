package com.bugscript.listwidget;

import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

/**
 * Created by syamsundark on 17/01/18.
 */

public class MyWidgetRemoteViewsService extends RemoteViewsService {
    private static final String TAG = "WidgetService";
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        Log.d(TAG, "onGetViewFactory: " + "Service called");
        return new MyWidgetRemoteViewsFactory(this.getApplicationContext(), intent);
    }
}
