package com.wonderland.alice.onofftester.screen

import android.app.admin.DevicePolicyManager
import android.content.Context
import android.os.PowerManager
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.wonderland.alice.onofftester.TAG

class ScreenManager(var context: Context) {

    private var wakeLock: PowerManager.WakeLock? = null

    fun screenOn() {
        try {
            Log.d(TAG, "Screen on Action")

            this.wakeLock?.let {
                it.release()
            }

            val powerManager =
                context.getSystemService(AppCompatActivity.POWER_SERVICE) as PowerManager
            this.wakeLock = powerManager.newWakeLock(
                PowerManager.SCREEN_DIM_WAKE_LOCK or
                        PowerManager.ACQUIRE_CAUSES_WAKEUP or
                        PowerManager.ON_AFTER_RELEASE,
                "Bright::WakelockTag"
            )
            this.wakeLock?.acquire(1 * 60 * 1000L)
        } catch (e: Exception) {
            Log.e(TAG, "scOnAction E:${e.message}")
        }
    }

    fun screenOff() {
        Log.d(TAG, "Screen off Action")
        try {
            val dpm =
                context.getSystemService(AppCompatActivity.DEVICE_POLICY_SERVICE) as DevicePolicyManager
            dpm.lockNow()
        } catch (e: Exception) {
            Log.e(TAG, "screenOff E:${e.message}")
        }
    }

}