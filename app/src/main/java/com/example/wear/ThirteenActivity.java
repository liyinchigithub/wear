package com.example.wear;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.wear.Broadcast.ActionUtils;
import com.example.wear.Broadcast.BatteryReceiver;
import com.example.wear.Broadcast.DyCustomerReceiver;
import com.example.wear.databinding.ActivityTwentyNineBinding;
import com.example.wear.service.BatteryService;

import java.util.ArrayList;

public class ThirteenActivity extends Activity {

    private TextView mTextView;
    private ActivityTwentyNineBinding binding;
    private DyCustomerReceiver  dyCustomerReceiver;
    private BatteryReceiver  batteryReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTwentyNineBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // mTextView = binding.text;

        // 启动Service
        startService(new Intent(this, BatteryService.class));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(batteryReceiver);// 注销广播
    }


}