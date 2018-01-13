package com.bugscript.widgetgadget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RemoteViews;

import com.bugscript.widgetgadget.services.ChangeImageService;

/**
 * Implementation of App Widget functionality.
 */
public class HelloWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int imgRes,int appWidgetId) {

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.android_widget);

        Intent intent=new Intent(context,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(context,0,intent,0);
        views.setOnClickPendingIntent(R.id.widget_git_image,pendingIntent);

        switch (imgRes){
            case 1:
                views.setImageViewResource(R.id.widget_git_image, R.drawable.github_img);
                break;
            case 2:
                views.setImageViewResource(R.id.widget_git_image, R.drawable.google);
                break;
            case 3:
                views.setImageViewResource(R.id.widget_git_image, R.drawable.benz);
                break;
            case 4:
                views.setImageViewResource(R.id.widget_git_image, R.drawable.apple);
                break;
            case 5:
                views.setImageViewResource(R.id.widget_git_image, R.drawable.facebook);
                break;
        }

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        ChangeImageService.startChangingImage(context);
    }

    public static void updateWidgetImage(Context context,AppWidgetManager appWidgetManager,int imgRes, int[] appWidgetIds){
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager,imgRes, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

