package com.example.wear.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
/**
 * 时间改变接收器
 * */
public class TimeChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // 在这里处理系统时间改变的操作
        // 您可以在此处执行您想要的操作，例如更新UI、执行特定任务等
        Log.d("TimeChangeReceiver", "onReceive");
        context.startService(new Intent(context, this.getClass()));
        context.stopService(new Intent(context, this.getClass()));
    }
}