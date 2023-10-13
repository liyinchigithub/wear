package com.example.wear.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
/**
 * 动态广播接收者（Receiver）
 * */
public class DyCustomerReceiver extends BroadcastReceiver {
    private  static final String TAG = DyCustomerReceiver.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "DyCustomerReceiver onReceive 广播接收者");
        // 从 Intent 对象中使用键 "customer" 返回一个 ArrayList 的字符串
        String[] value= intent.getStringArrayListExtra("customer")
                .toArray(new String[0]);// 将 ArrayList 转换为 String 数组
        //  参数 new String[0] 被传递以指定结果数组的类型
        Log.d(TAG, String.valueOf(value[0]));// 因为 Log.d() 方法期望一个 String 参数
        Log.d(TAG, String.valueOf(value[1]));
    }
}
