package com.example.wear;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.example.wear.broadcast.KeyRecordBroadcastReceiver;
import com.example.wear.databinding.ActivityTwentyFourBinding;

public class TwentyFourActivity extends Activity {
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private boolean permissionToRecordAccepted = false;
    private String[] permissions = {Manifest.permission.RECORD_AUDIO};
    private KeyRecordBroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twenty_four);

        // 创建广播接收器实例
        receiver = new KeyRecordBroadcastReceiver();

        // 注册广播接收器
        IntentFilter filter = new IntentFilter();//
        filter.addAction(Intent.ACTION_MEDIA_BUTTON);//
        registerReceiver(receiver, filter);

        // 申请录音权限（权限弹窗）
        ActivityCompat.requestPermissions(this, permissions, REQUEST_RECORD_AUDIO_PERMISSION);
    }

    /**
     *
     * */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // 判断
        if (requestCode == REQUEST_RECORD_AUDIO_PERMISSION) {
            permissionToRecordAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 判断是否已同意录音权限
        if (permissionToRecordAccepted) {
            // Register the broadcast receiver to listen for media button events
            receiver = new KeyRecordBroadcastReceiver();
            IntentFilter filter = new IntentFilter(Intent.ACTION_MEDIA_BUTTON);
            registerReceiver(receiver, filter);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister the broadcast receiver
        unregisterReceiver(receiver);
    }


}