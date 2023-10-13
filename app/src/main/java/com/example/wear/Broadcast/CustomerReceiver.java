package com.example.wear.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


/**
 *  广播接收者
 *  BroadcastReceiver的实现类
 * */
public class CustomerReceiver extends BroadcastReceiver {
    private  static final String TAG = CustomerReceiver.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "CustomerReceiver onReceive 广播接收者");
        String message=intent.getStringExtra("customer");
        if (message != null) {
            Log.d(TAG, String.valueOf(message));
        }
    }

}
