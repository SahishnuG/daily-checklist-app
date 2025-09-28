# DailyChecklist Widget App

A simple Android widget that allows users to create a daily checklist.

* Enter a list of tasks (comma-separated).
* The widget displays tasks with checkboxes.
* All checkboxes reset daily at 6 AM (phone time).

---

## Project Structure

com.example.checklist

* DailyChecklist.kt                 # AppWidgetProvider
* DailyChecklistConfigureActivity.kt # Widget configuration screen
* ChecklistService.kt               # Supplies tasks to the widget ListView
* ResetReceiver.kt                  # Resets checkboxes daily at 6 AM
* MainActivity.kt                   # Optional main launcher activity

res/layout/

* daily_checklist.xml               # Widget layout (ListView)
* checklist_item.xml                # Row layout for each task (checkbox + text)
* daily_checklist_configure.xml     # Configure activity layout

res/xml/

* daily_checklist_info.xml          # Widget metadata

---

## Prerequisites

* Android Studio (Arctic Fox or newer recommended)
* Android device or emulator with API level 21+
* USB debugging enabled on the device

---

## Installation / Running

1. Clone the repository

   git clone https://github.com/SahishnuG/daily-checklist-app.git

2. Open in Android Studio

   File → Open → Select project root

3. Sync Gradle

   Android Studio should prompt automatically.
   If not: File → Sync Project with Gradle Files.

4. Build and run

   * Connect your phone via USB (enable USB debugging).
   * Select your device and click Run (Shift + F10).
   * App will install on your phone.

---

## Adding the Widget

1. Long press on your home screen → Widgets
2. Scroll to find **Daily Checklist**
3. Drag it to your home screen
4. The configuration screen opens:

   * Enter tasks separated by commas, e.g., Buy milk, Call Mom, Check email
   * Tap Save
5. The widget displays your tasks with checkboxes.

> Checkboxes reset automatically at 6 AM every day.

---

## Notes

* Updating tasks: Remove and re-add the widget to change tasks.
* Checkbox state: Managed by the widget service and reset by ResetReceiver.
* Resizing: Widget supports horizontal and vertical resizing.

---

## Dependencies

* androidx.appcompat:appcompat:1.6.1
* androidx.core:core-ktx:1.12.0
* androidx.lifecycle:lifecycle-runtime-ktx:2.6.2
* androidx.activity:activity-compose:1.9.0
* androidx.compose libraries (optional if using Compose in future)

---

## Tips / Troubleshooting

* Widget not appearing? Make sure:

  * DailyChecklistConfigureActivity does not have an intent-filter
  * <receiver> and configure activity have android:exported="true"
  * You uninstalled old APK before reinstalling
  * Device launcher is refreshed (some require reboot for new widgets)

* Check logcat in Android Studio if the widget does not show.
