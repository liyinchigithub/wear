package com.example.wear;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;


import com.example.wear.databinding.ActivityThirdBinding;

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

        // 获取位置信息
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        // 检查是否有权限 如果没有权限，请求权限
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    // manifest 中声明了权限，这里就要声明一下
                    Manifest.permission.ACCESS_FINE_LOCATION}, 1);
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