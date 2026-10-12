package com.atsugiseinan.jikanwaripro

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import java.text.SimpleDateFormat
import java.util.*

class CalendarWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            val views = RemoteViews(context.packageName, R.layout.widget_calendar)

            // 今月の年月を自動取得・更新
            val monthFormat = SimpleDateFormat("yyyy年 M月", Locale.JAPANESE)
            val currentMonth = monthFormat.format(Date())
            views.setTextViewText(R.id.widget_month_title, currentMonth)

            // タップ時にアプリのカレンダーページを開くインテント
            val intent = Intent(context, MainActivity::class.java).apply {
                putExtra("NAVIGATE_TAB", "subjectCalendar")
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            val pendingIntent = PendingIntent.getActivity(
                context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
            views.setOnClickPendingIntent(R.id.widget_calendar_root, pendingIntent)

            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}
