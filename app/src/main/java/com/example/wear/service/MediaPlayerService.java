package com.example.wear.service;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import com.example.wear.R;

public class MediaPlayerService extends Service {
    private MediaPlayer mediaPlayer;

    /**
     * 两种启动服务的生命
     * startService： onCreate() -> onStartCommand() -> onDestroy()
     * bindService： onCreate() -> onBind() -> onUnbind() -> onDestroy()
     * */

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.music);//
        mediaPlayer.setLooping(true);
        Log.d("MediaPlayerService", "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 播放音频
        mediaPlayer.setVolume(1.0f, 1.0f);// 设置音量
        mediaPlayer.setLooping(true);// 循环播放
        mediaPlayer.start();
        Log.d("MediaPlayerService", "onStartCommand()");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            Log.d("MediaPlayerService", "onDestroy()");
        }
    }

    /**
     * 音乐播放器，不适合使用Bind
     * */
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