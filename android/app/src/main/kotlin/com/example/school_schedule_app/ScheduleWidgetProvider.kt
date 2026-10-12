package com.example.school_schedule_app

import android.appwidget.AppWidgetManager
import android.content.Context
import android.widget.RemoteViews
import es.antonborri.home_widget.HomeWidgetProvider

class ScheduleWidgetProvider : HomeWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray,
        widgetData: android.content.SharedPreferences
    ) {
        appWidgetIds.forEach { widgetId ->
            val views = RemoteViews(context.packageName, R.layout.schedule_widget_layout).apply {
                val title = widgetData.getString("widget_title", "本日のスクーリング")
                val content = widgetData.getString("widget_content", "予定はありません")
                
                setTextViewText(R.id.widget_title, title)
                setTextViewText(R.id.widget_content, content)
            }
            appWidgetManager.updateAppWidget(widgetId, views)
        }
    }
}
