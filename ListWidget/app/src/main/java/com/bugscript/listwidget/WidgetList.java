package com.bugscript.listwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.bugscript.listwidget.services.ChangeContentsService;

/**
 * Implementation of App Widget functionality.
 */
public class WidgetList extends AppWidgetProvider {

    public static final String EXTRA_LABEL = "TASK_TEXT";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            RemoteViews views = new RemoteViews(

                    context.getPackageName(),
                    R.layout.widget_list

            );
            Intent intent = new Intent(context, MyWidgetRemoteViewsService.class);
            views.setRemoteAdapter(R.id.widgetListView, intent);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }


    public static void sendRefreshBroadcast(Context context) {
        Intent intent = new Intent(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        intent.setComponent(new ComponentName(context, WidgetList.class));
        context.sendBroadcast(intent);
    }


    @Override
    public void onReceive(final Context context, Intent intent) {
        final String action = intent.getAction();
        if (action.equals(AppWidgetManager.ACTION_APPWIDGET_UPDATE)) {
            // refresh all your widgets
            AppWidgetManager mgr = AppWidgetManager.getInstance(context);
            ComponentName cn = new ComponentName(context, WidgetList.class);
            mgr.notifyAppWidgetViewDataChanged(mgr.getAppWidgetIds(cn), R.id.widgetListView);
        }
        super.onReceive(context, intent);
    }
}

