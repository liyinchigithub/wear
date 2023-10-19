package com.example.wear;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wear.databinding.ActivityFourteenBinding;

/**
 * 相机相册14
 * */
public class FourteenActivity extends Activity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;//
    private static final int REQUEST_IMAGE_PICK = 2;
    private TextView mTextView;
    private ActivityFourteenBinding binding;
    private MediaPlayer mediaPlayer;
    //
    boolean isPaused = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFourteenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        mTextView = binding.text;
        // 打开相机
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
        // 打开相册
        Button btnOpenGallery = findViewById(R.id.btnOpenGallery);
        btnOpenGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建一个隐式的Intent，指定ACTION_PICK动作和图片类型
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                // 检查设备是否有相册应用可用
                if (intent.resolveActivity(getPackageManager()) != null) {
                    // 启动相册应用，并等待选择结果
                    startActivityForResult(intent, REQUEST_IMAGE_PICK);
                } else {
                    Toast.makeText(FourteenActivity.this, "无法打开相册", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 播放音频
        Button btnPlayAudio = findViewById(R.id.btnPlayAudio);

        // 监听播放按钮
        btnPlayAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) {
                    // 如果MediaPlayer对象为空，则创建并开始播放音频文件
                    mediaPlayer = MediaPlayer.create(FourteenActivity.this, R.raw.music);
                    mediaPlayer.start();
                } else {
                    if (isPaused) {
                        // 如果音频已暂停，则继续播放
                        mediaPlayer.start();
                        isPaused = false;
                    } else {
                        // 如果音频正在播放，则暂停播放
                        mediaPlayer.pause();
                        isPaused = true;
                    }
                }
            }
        });
        //
        Button btnPauseAudio = findViewById(R.id.btnPauseAudio);
        // 监听暂停播放按钮
        btnPauseAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    // 如果音频正在播放，则暂停播放
                    mediaPlayer.pause();
                } else {
                    // 如果音频没有在播放，则开始播放
                    mediaPlayer = MediaPlayer.create(FourteenActivity.this, R.raw.music);
                    mediaPlayer.start();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 释放 MediaPlayer 资源
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 相机
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // 从Intent中获取拍摄结果照片
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            // 在这里处理拍摄结果照片
            // 您可以将照片显示在ImageView中，保存到本地等
        }
        // 相册
        if (requestCode == REQUEST_IMAGE_PICK && resultCode == RESULT_OK) {
            // 从Intent中获取选中的照片的URI
            Uri selectedImageUri = data.getData();

            // 在这里处理选中的照片
            // 您可以将照片显示在ImageView中，保存到本地等
        }
    }


}