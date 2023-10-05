package com.example.wear;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wear.databinding.ActivityFourteenBinding;

public class FourteenActivity extends Activity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private TextView mTextView;
    private ActivityFourteenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFourteenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        mTextView = binding.text;
        Button btnOpenCamera = findViewById(R.id.btnOpenCamera);
        btnOpenCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建一个隐式的Intent，指定ACTION_IMAGE_CAPTURE动作
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                // 检查设备是否有相机应用可用
                if (intent.resolveActivity(getPackageManager()) != null) {
                    // 启动相机应用，并等待拍摄结果
                    startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
                } else {
                    Toast.makeText(FourteenActivity.this, "无法打开相机", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // 从Intent中获取拍摄结果照片
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            // 在这里处理拍摄结果照片
            // 您可以将照片显示在ImageView中，保存到本地等
        }
    }
}