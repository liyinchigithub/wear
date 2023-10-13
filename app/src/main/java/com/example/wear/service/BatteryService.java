package com.example.wear.service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import com.example.wear.Broadcast.BatteryReceiver;

public class BatteryService extends Service {
    private BatteryReceiver  batteryReceiver;
    /**
     * 两种启动服务的生命
     * startService： onCreate() -> onStartCommand() -> onDestroy()
     * bindService： onCreate() -> onBind() -> onUnbind() -> onDestroy()
     */
    public BatteryService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // 动态注册广播-系统广播（电池信息发生改变）
        batteryReceiver = new BatteryReceiver();
        IntentFilter batteryIntentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryReceiver, batteryIntentFilter);
        Log.d("BatteryService", "onCreate");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("BatteryService", "onStartCommand");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("BatteryService", "onDestroy");
        unregisterReceiver(batteryReceiver);// 注销广播
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("BatteryService", "onBind");
        throw new UnsupportedOperationException("Not yet implemented");
    }
}