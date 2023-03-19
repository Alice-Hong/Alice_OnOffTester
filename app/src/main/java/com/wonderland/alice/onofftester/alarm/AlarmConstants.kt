package com.wonderland.alice.onofftester.alarm

import androidx.annotation.Keep

@Keep
enum class ACT_SCREEN(
    val action: String,
    val requestCode: Int,
) {
    SCREEN_ON(
        "actionScreenOn", 101
    ),
    SCREEN_OFF(
        "actionScreenOff", 201
    );
}