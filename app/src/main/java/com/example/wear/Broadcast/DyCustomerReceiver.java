package com.example.wear.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Arrays;

/**
 * 动态广播接收者（Receiver）
 * 自定义广播
 * */
public class DyCustomerReceiver extends BroadcastReceiver {
    private  static final String TAG = DyCustomerReceiver.class.getSimpleName();// 当前类名
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "DyCustomerReceiver onReceive 广播接收者");
        // 从 Intent 对象中使用键 "customer1" 返回一个字符串
        String value1 = intent.getStringExtra("customer1");
        Log.d(TAG, value1);//

        // 从 Intent 对象中使用键 "customer" 返回一个 ArrayList 的字符串
        String[] value= intent.getStringArrayListExtra("customer")
                .toArray(new String[0]);// 将 ArrayList 转换为 String 数组
        //  参数 new String[0] 被传递以指定结果数组的类型
        Log.d(TAG, String.valueOf(value));// 内存地址
        Log.d(TAG, Arrays.asList(value).toString());// Arrays.asList(value)
        Log.d(TAG, Arrays.toString(value));// 数组
        Log.d(TAG, String.valueOf(value[0]));// 因为 Log.d() 方法期望一个 String 参数，所以要转化数据类型为String
        Log.d(TAG, String.valueOf(value[1]));


    }
}
