package com.example.wear.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/**
 * 将参数从BroadcastReceiver传递给所有注册了该广播的Activity
 * 使用LocalBroadcastManager来实现。
 * LocalBroadcastManager允许你在应用内部发送和接收广播，只有在[同一个应用内]的组件才能接收到这些广播
 * */
public class MyBroadcastReceiver  extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        //  获取
        String data = intent.getStringExtra("key");

        // 创建一个新的Intent
        Intent broadcastIntent = new Intent(ActionUtils.ACTION_BROADCAST_TO_ACTIVITY_FLAG);
        broadcastIntent.putExtra("key", data);

        // 发送本地广播
        LocalBroadcastManager.getInstance(context).sendBroadcast(broadcastIntent);
    }
}
