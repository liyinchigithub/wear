package com.example.wear.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class StepService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        // 在这里初始化你的Service
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 在这里处理你的Service的任务
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // 如果你的Service不需要和其他组件绑定，你可以返回null
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 在这里清理你的Service
    }
}
