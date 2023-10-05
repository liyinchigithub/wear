package com.example.wear.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TimeChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // 在这里处理系统时间改变的操作
        // 您可以在此处执行您想要的操作，例如更新UI、执行特定任务等
    }
}