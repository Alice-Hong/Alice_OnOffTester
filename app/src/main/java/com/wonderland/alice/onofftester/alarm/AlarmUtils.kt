package com.wonderland.alice.onofftester.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.wonderland.alice.onofftester.MainActivity.Companion.rootScreenOnAtAlarm
import com.wonderland.alice.onofftester.SCREEN_OFF_TIMER
import com.wonderland.alice.onofftester.SCREEN_ON_TIMER
import com.wonderland.alice.onofftester.TAG
import com.wonderland.alice.onofftester.screen.ScreenManager
import java.util.*


class AlarmUtils(private val context: Context) {

    private val mAlarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    fun setAlarm(act: ACT_SCREEN) {
        try {
            val calendar = Calendar.getInstance()
            if (act == ACT_SCREEN.SCREEN_ON) {
                calendar.add(Calendar.MINUTE, SCREEN_ON_TIMER)
            } else {
                calendar.add(Calendar.MINUTE, SCREEN_OFF_TIMER)
            }
            val pendingIntent = makePendingIntent(act)
            if (pendingIntent != null) {
                clearAlarm(pendingIntent)
                setAlarm(calendar, pendingIntent)
            }
        } catch (e: Exception) {
            Log.e(TAG, "setAlarm Error:${e.message}")
        }
    }

    fun cancelAlarm() {
        Log.d(TAG, "cancelAlarm")

        makePendingIntent(ACT_SCREEN.SCREEN_ON, isCancel = false)?.apply {
            mAlarmManager.cancel(this)
        }
        makePendingIntent(ACT_SCREEN.SCREEN_OFF, isCancel = false)?.apply {
            mAlarmManager.cancel(this)
        }
    }

    private fun makePendingIntent(act: ACT_SCREEN, isCancel: Boolean = false): PendingIntent? {

        val alarmIntent =
            Intent(context.applicationContext, AlarmBroadcastReceiver::class.java).apply {
                action = act.action
            }

        if (isCancel) {
            return PendingIntent.getBroadcast(
                context.applicationContext,
                act.requestCode,
                alarmIntent,
                PendingIntent.FLAG_NO_CREATE
            )
        } else {
            return PendingIntent.getBroadcast(
                context.applicationContext,
                act.requestCode,
                alarmIntent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        }
    }

    private fun setAlarm(setCalendar: Calendar, pendingIntent: PendingIntent) {
        mAlarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            setCalendar.timeInMillis,
            pendingIntent
        )
    }

    private fun clearAlarm(pendingIntent: PendingIntent) {
        mAlarmManager.let {
            it.cancel(pendingIntent)
        }
    }
}

class AlarmBroadcastReceiver() : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val alarmUtils = AlarmUtils(context)
        val action = intent.action ?: return
        Log.d(TAG, "onReceive : $action")

        when (action) {
            ACT_SCREEN.SCREEN_OFF.action -> {
                rootScreenOnAtAlarm = true
                alarmUtils.setAlarm(ACT_SCREEN.SCREEN_ON)
                ScreenManager(context.applicationContext).screenOn()
            }
            ACT_SCREEN.SCREEN_ON.action -> {
                rootScreenOnAtAlarm = false
                alarmUtils.setAlarm(ACT_SCREEN.SCREEN_OFF)
                ScreenManager(context).screenOff()

            }
        }
    }
}