package com.example.wear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.wear.databinding.ActivityThirtyOneBinding;
import com.example.wear.service.BatteryService;
public class ThirtyOneActivity extends Activity {
    private TextView mTextView;
    private ActivityThirtyOneBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThirtyOneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // 启动BatteryService
        startService(new Intent(this, BatteryService.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 页面销毁即停止BatteryService，如果想要退出页面仍要显示BatteryService，则注释掉此行
        stopService(new Intent(this, BatteryService.class));
    }
}