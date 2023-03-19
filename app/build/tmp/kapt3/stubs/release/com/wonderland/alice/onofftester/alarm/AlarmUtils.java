package com.wonderland.alice.onofftester.alarm;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/wonderland/alice/onofftester/alarm/AlarmUtils;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mAlarmManager", "Landroid/app/AlarmManager;", "cancelAlarm", "", "clearAlarm", "pendingIntent", "Landroid/app/PendingIntent;", "makePendingIntent", "act", "Lcom/wonderland/alice/onofftester/alarm/ACT_SCREEN;", "isCancel", "", "setAlarm", "setCalendar", "Ljava/util/Calendar;", "app_release"})
public final class AlarmUtils {
    private final android.content.Context context = null;
    private final android.app.AlarmManager mAlarmManager = null;
    
    public AlarmUtils(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void setAlarm(@org.jetbrains.annotations.NotNull()
    com.wonderland.alice.onofftester.alarm.ACT_SCREEN act) {
    }
    
    public final void cancelAlarm() {
    }
    
    private final android.app.PendingIntent makePendingIntent(com.wonderland.alice.onofftester.alarm.ACT_SCREEN act, boolean isCancel) {
        return null;
    }
    
    private final void setAlarm(java.util.Calendar setCalendar, android.app.PendingIntent pendingIntent) {
    }
    
    private final void clearAlarm(android.app.PendingIntent pendingIntent) {
    }
}