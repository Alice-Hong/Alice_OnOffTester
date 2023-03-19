package com.wonderland.alice.onofftester;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\u0012\u0010!\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\u001eH\u0014J\b\u0010%\u001a\u00020\u001eH\u0002J\u0012\u0010&\u001a\u00020\u001e2\b\b\u0002\u0010\'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\u001eH\u0002J\b\u0010*\u001a\u00020\u001eH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006,"}, d2 = {"Lcom/wonderland/alice/onofftester/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "_bindging", "Lcom/wonderland/alice/onofftester/databinding/ActivityMainBinding;", "alarmUtils", "Lcom/wonderland/alice/onofftester/alarm/AlarmUtils;", "getAlarmUtils", "()Lcom/wonderland/alice/onofftester/alarm/AlarmUtils;", "alarmUtils$delegate", "Lkotlin/Lazy;", "bindging", "getBindging", "()Lcom/wonderland/alice/onofftester/databinding/ActivityMainBinding;", "countDownTimer", "Landroid/os/CountDownTimer;", "deviceAdminResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "screenOnOffFilter", "Landroid/content/IntentFilter;", "screenOnReceiver", "Landroid/content/BroadcastReceiver;", "viewModel", "Lcom/wonderland/alice/onofftester/MainViewModel;", "getViewModel", "()Lcom/wonderland/alice/onofftester/MainViewModel;", "viewModel$delegate", "activateAdmin", "", "initializeClickListener", "initializeUI", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "screenOffAction", "showTimer", "count", "", "testStart", "testStop", "Companion", "app_release"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final com.wonderland.alice.onofftester.MainActivity.Companion Companion = null;
    private static boolean rootScreenOnAtAlarm = false;
    private com.wonderland.alice.onofftester.databinding.ActivityMainBinding _bindging;
    private final kotlin.Lazy viewModel$delegate = null;
    private final kotlin.Lazy alarmUtils$delegate = null;
    private android.os.CountDownTimer countDownTimer;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> deviceAdminResult = null;
    private android.content.BroadcastReceiver screenOnReceiver;
    private final android.content.IntentFilter screenOnOffFilter = null;
    
    public MainActivity() {
        super();
    }
    
    private final com.wonderland.alice.onofftester.databinding.ActivityMainBinding getBindging() {
        return null;
    }
    
    private final com.wonderland.alice.onofftester.MainViewModel getViewModel() {
        return null;
    }
    
    private final com.wonderland.alice.onofftester.alarm.AlarmUtils getAlarmUtils() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    private final void initializeUI() {
    }
    
    private final void initializeClickListener() {
    }
    
    private final void testStart() {
    }
    
    private final void testStop() {
    }
    
    private final void activateAdmin() {
    }
    
    private final void screenOffAction() {
    }
    
    private final void showTimer(int count) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/wonderland/alice/onofftester/MainActivity$Companion;", "", "()V", "rootScreenOnAtAlarm", "", "getRootScreenOnAtAlarm", "()Z", "setRootScreenOnAtAlarm", "(Z)V", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean getRootScreenOnAtAlarm() {
            return false;
        }
        
        public final void setRootScreenOnAtAlarm(boolean p0) {
        }
    }
}