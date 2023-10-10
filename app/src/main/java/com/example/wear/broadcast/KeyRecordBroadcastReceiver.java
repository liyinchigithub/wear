package com.example.wear.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import java.io.IOException;

public class KeyRecordBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "KeyRecordBroadcastReceiver";
    private int clickCount = 0;//  记录点击次数
    private long lastClickTime = 0;//  最后一次点击时间
    private Context context; // 添加一个Context字段
    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context; // 初始化Context字段
        // 判断是否是按键音
        if (intent.getAction().equals(Intent.ACTION_MEDIA_BUTTON)) {
            //  获取按键事件
            KeyEvent event = intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
            // 判断按键是否是音量键
            if (event.getKeyCode() == KeyEvent.KEYCODE_VOLUME_DOWN) {
                long currentTime = System.currentTimeMillis();//  获取当前时间
                //
                if (currentTime - lastClickTime < 1000) {
                    clickCount++;
                } else {
                    clickCount = 1;
                }
                lastClickTime = currentTime;//

                if (clickCount == 1) {
                    // Start recording
                    startRecording();
                    clickCount = 0;
                }
            }
        }
        Log.d(TAG, "onReceive() called");
    }

    private void startRecording() {
        // 创建一个MediaRecorder对象
        MediaRecorder recorder = new MediaRecorder();
        // 设置音频源为麦克风
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        // 设置音频输出格式为默认格式
        recorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
        // 设置音频编码器为默认编码器
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
        // 设置录音文件的保存路径和文件名
        String filePath = context.getExternalFilesDir(null).getAbsolutePath() + "/recording.mp3";
        Log.d(TAG, "filePath: " + filePath);
        recorder.setOutputFile(filePath);

        try {
            // 准备录音
            recorder.prepare();
            // 开始录音
            recorder.start();
            Log.d(TAG, "startRecording() called");
            // 在这里可以添加一些UI提示，例如显示一个录音中的通知
            Toast.makeText(context, "开始录音", Toast.LENGTH_SHORT).show();
            // 录音持续一段时间后停止录音
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // 停止录音
                    recorder.stop();
                    // 释放资源
                    recorder.release();
                    // 在这里可以添加一些UI提示，例如显示一个录音完成的通知

                    // 处理录音文件，例如上传到服务器或保存到本地

                }
            }, 5000); // 录音持续时间为5秒

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
