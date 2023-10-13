package com.example.wear.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.Toast;

/**
 * 广播接收者
 * 监听电量变化
 * 当电池电量发生变化时，BatteryReceiver接收器将会接收到广播，并根据电量是否低于30%来显示toast提示
 * */
public class BatteryReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //
        if (Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())) {
            int batteryLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int batteryScale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            float batteryPercentage = (batteryLevel / (float) batteryScale) * 100;

            if (batteryPercentage < 30) {
                Toast.makeText(context, "电池电量低于30%", Toast.LENGTH_SHORT).show();
                Log.d("BatteryReceiver", "onReceive: " + String.valueOf(batteryPercentage)+"%");
            }
        }

        // 接收广播ACTION_DY_BATTERY_FLAG参数
        String message =intent.getStringExtra("battery");
        if (message != null) {
            Log.d("BatteryReceiver", "onReceive: " + String.valueOf(message));
        }

    }
}