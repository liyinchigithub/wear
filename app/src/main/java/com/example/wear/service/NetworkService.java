package com.example.wear.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class NetworkService extends Service {

    /**
     * 两种启动服务的生命
     * startService： onCreate() -> onStartCommand() -> onDestroy()
     * bindService： onCreate() -> onBind() -> onUnbind() -> onDestroy()
     * */

   @Override
    public void onCreate() {
        super.onCreate();
        // 在这里初始化你的Service
       Log.d("NetworkService", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 在这里处理你的Service的任务
        Log.d("NetworkService", "onStartCommand");
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // 如果你的Service不需要和其他组件绑定，你可以返回null
        Log.d("NetworkService", "onBind");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        // 如果你的Service不需要和其他组件绑定，你可以返回false
        Log.d("NetworkService", "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 在这里清理你的Service
        Log.d("NetworkService", "onDestroy");
    }


}
