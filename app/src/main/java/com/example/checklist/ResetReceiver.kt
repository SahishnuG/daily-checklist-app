package com.example.checklist

import android.appwidget.AppWidgetManager
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent

class ResetReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val prefs = context.getSharedPreferences("ChecklistPrefs", Context.MODE_PRIVATE)
        val tasks = prefs.getStringSet("tasks", emptySet()) ?: emptySet()
        prefs.edit().putStringSet("tasks", tasks).apply() // reset checkboxes

        val manager = AppWidgetManager.getInstance(context)
        val ids = manager.getAppWidgetIds(ComponentName(context, DailyChecklist::class.java))
        manager.notifyAppWidgetViewDataChanged(ids, R.id.widgetListView)
    }
}
