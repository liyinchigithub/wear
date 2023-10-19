package com.example.wear;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;

import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;


import com.example.wear.databinding.ActivityThirdBinding;

/**
 * 定位
 * */
public class ThirdActivity extends Activity {

    private TextView mTextView;
    private ActivityThirdBinding binding;
    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 初始化 binding 对象 用于控制第三个页面中元素的显示
        binding = ActivityThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // 通过 binding 对象找到activity_third.xml中 titleActivityThird 对象，然后调用 setText 方法设置文本
        mTextView = binding.titleActivityThird;
        //  设置文本
        mTextView.setText("Third Activity");
        // 【获取位置信息】
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        // 检查是否有权限 如果没有权限，请求权限
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // 创建一个 AlertDialog.Builder 对象
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            // 设置标题和消息
            builder.setTitle("需要定位权限");
            builder.setMessage("我们需要获取您的位置信息，以便为您提供更好的服务。");
            // 设置确定按钮，当用户点击确定按钮时请求权限
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(ThirdActivity.this, new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                    // 日志输出定位信息
                    Log.d("ThirdActivity", "onClick: " + "请求权限");

                }

            });
            //  设置取消按钮
            builder.setNeutralButton("取消", null);
            // 创建对话框
            AlertDialog dialog = builder.create();
            // 显示对话框
            dialog.show();
            // 获取按钮样式
            Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            positiveButton.setTextSize(15);
            // 显示按钮边框
            positiveButton.setTextColor(Color.BLUE);
            Button neutralButton = dialog.getButton(AlertDialog.BUTTON_NEUTRAL);
            neutralButton.setTextSize(15);
            // 显示按钮边框
            neutralButton.setTextColor(Color.WHITE);


        } else {
            // 如果有权限，获取位置信息
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // 如果位置信息不为空
                            if (location != null) {
                                // 设置文本
                                mTextView.setText("Latitude: " + location.getLatitude() + ", Longitude: " + location.getLongitude());
                            }
                        }
                    });
        }

    }
}