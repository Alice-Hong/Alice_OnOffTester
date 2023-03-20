package com.wonderland.alice.onofftester

import android.content.Context
import android.content.SharedPreferences


private const val PREF_NAME = "powerutils.preference"
private const val PREF_SCREEN_ON_TIMER_KEY = "prefScreenOnTimerKey"
private const val PREF_SCREEN_OFF_TIMER_KEY = "prefScreenTimerOffKey"

object UserPreferencesRepository {

    private lateinit var pref: SharedPreferences

    fun init(context: Context) {
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    var screenOnTimer: Int
        get() {
            return pref.getInt(PREF_SCREEN_ON_TIMER_KEY, SCREEN_ON_TIMER)
        }
        set(value) {
            pref.edit().putInt(PREF_SCREEN_ON_TIMER_KEY, value).apply()
        }

    var screenOffTimer: Int
        get() {
            return pref.getInt(PREF_SCREEN_OFF_TIMER_KEY, SCREEN_OFF_TIMER)
        }
        set(value) {
            pref.edit().putInt(PREF_SCREEN_OFF_TIMER_KEY, value).apply()
        }
}