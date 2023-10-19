package com.example.wear;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wear.Broadcast.TimeChangeReceiver;
import com.example.wear.databinding.ActivityTwelveBinding;

/**
 * 广播
 * 系统广播-时间改变
 * */
public class TwelveActivity extends Activity {

    private TextView mTextView;
    private ActivityTwelveBinding binding;
    private TimeChangeReceiver timeChangeReceiver;// BroadcastReceiver的实现类

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTwelveBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTextView = binding.text;

        // 针对系统时间改变的广播注册和接收。
        // 当系统时间发生改变时，您的广播接收器将收到相应的广播，并在onReceive()方法中执行您想要的操作
        // 创建广播接收器实例
        timeChangeReceiver = new TimeChangeReceiver();
        // 创建IntentFilter并添加对ACTION_TIME_CHANGED的过滤
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_TIME_CHANGED);

        // 注册广播接收器
        registerReceiver(timeChangeReceiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 取消注册广播接收器
        unregisterReceiver(timeChangeReceiver);
    }
}