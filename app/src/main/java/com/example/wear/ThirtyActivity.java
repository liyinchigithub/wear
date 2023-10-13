package com.example.wear;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wear.databinding.ActivityThirtyBinding;
import com.example.wear.service.BatteryService;
public class ThirtyActivity extends Activity {
    private TextView mTextView;
    private ActivityThirtyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThirtyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // 启动BatteryService
        startService(new Intent(this, BatteryService.class));
    }
}