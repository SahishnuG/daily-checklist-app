package com.example.checklist

import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService

class ChecklistService : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent): RemoteViewsFactory {
        return ChecklistFactory(applicationContext)
    }
}

class ChecklistFactory(private val context: Context) : RemoteViewsService.RemoteViewsFactory {
    private val tasks = mutableListOf<Pair<String, Boolean>>() // task, checked?

    override fun onCreate() {}
    override fun onDataSetChanged() {
        val prefs = context.getSharedPreferences("ChecklistPrefs", Context.MODE_PRIVATE)
        val taskSet = prefs.getStringSet("tasks", emptySet()) ?: emptySet()
        tasks.clear()
        taskSet.forEach { tasks.add(it to false) }
    }

    override fun getViewAt(position: Int): RemoteViews {
        val (task, checked) = tasks[position]
        val rv = RemoteViews(context.packageName, R.layout.checklist_item)
        rv.setTextViewText(R.id.widgetItemText, task)
        rv.setBoolean(R.id.widgetItemCheckbox, "setChecked", checked)
        return rv
    }

    override fun getCount() = tasks.size
    override fun getLoadingView(): RemoteViews? = null
    override fun getViewTypeCount() = 1
    override fun getItemId(position: Int) = position.toLong()
    override fun hasStableIds() = true
    override fun onDestroy() {}
}
