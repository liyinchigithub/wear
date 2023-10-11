package com.example.wear.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import com.example.wear.R;

import java.io.IOException;

public class MediaPlayerService extends Service {
    private MediaPlayer mediaPlayer;

    /**
     * 两种启动服务的生命
     * startService： onCreate() -> onStartCommand() -> onDestroy()
     * bindService： onCreate() -> onBind() -> onUnbind() -> onDestroy()
     */

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(MediaPlayerService.this, R.raw.music);//
        mediaPlayer.setLooping(true);
        Log.d("MediaPlayerService", "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 播放音频
        mediaPlayer.setVolume(1.0f, 1.0f);// 设置音量
        mediaPlayer.setLooping(false);// 循环播放
        mediaPlayer.start();// 播放
        Log.d("MediaPlayerService", "onStartCommand()");
        return START_STICKY;// 返回START_STICKY以指示如果服务被终止，应重新启动服务
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        停止并释放MediaPlayer对象
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            Log.d("MediaPlayerService", "onDestroy()");
        }
    }

    /**
     * 音乐播放器，不适合使用Bind
     */
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("MediaPlayerService", "onBind()");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("MediaPlayerService", "onUnbind()");
        return super.onUnbind(intent);
    }
}