package com.example.wear;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.example.wear.databinding.ActivityTenBinding;
/**
 * 发送通知
 * */
public class TenActivity extends Activity {

    private TextView mTextView;
    private ActivityTenBinding binding;

    private NotificationManager mNotificationManager;
    private Notification notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //  通知管理器
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);// 获取通知管理器
        // 判断是否是8.0及以上
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // 创建通知渠道
            NotificationChannel  channel= new NotificationChannel("leo","测试通知881027",NotificationManager.IMPORTANCE_HIGH);// 参数：通知渠道id，通知渠道名称，通知重要性
            // 设置通知渠道的描述
            channel.setDescription("通知渠道的描述：测试通知881027");
            // 设置通知出现时的闪灯（如果android设备支持的话）
            channel.enableLights(true);
            // 设置通知出现时的震动（如果android设备支持的话）
            channel.enableVibration(true);
            // 设置通知出现时的声音（如果android设备支持的话）
            channel.setSound(null,null);
            // 设置通知出现时是否在桌面图标右上角展示小红点
            channel.setShowBadge(true);
            mNotificationManager.createNotificationChannel(channel);

        }
        // 创建通知
         notification = new NotificationCompat.Builder(this,"leo")
                .setContentTitle("通知标题")// 设置通知的标题
                .setContentText("通知内容：Android开发基础教程，从零开始，让你以最快的速度入门Android开发。\n" +
                        "内容较多，大家可以收藏后慢慢看~~求三连~Android开发基础教程，从零开始，让你以最快的速度入门Android开发。\n" +
                        "内容较多，大家可以收藏后慢慢看~~求三连~Android开发基础教程，从零开始，让你以最快的速度入门Android开发。\n" +
                        "内容较多，大家可以收藏后慢慢看~~求三连~")// 设置通知的内容
                  .setSmallIcon(R.mipmap.ic_launcher)// 设置通知的小图标
                 .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_demo))
                 .setContentIntent(PendingIntent.getActivity(this,0,new Intent(this,MainActivity.class),0))//
                 .build();

    }
    /**
     * 发送通知
     * */
    public void sendNotification(View view) {
        // 发送通知
        mNotificationManager.notify(1,notification);
        // 获取执行结果
        boolean result = mNotificationManager.areNotificationsEnabled();
        Log.d("TAG", "sendNotification: "+result);
        Toast.makeText(this,"发送通知",Toast.LENGTH_SHORT).show();
    }
    /**
     * 取消通知
     * */
    public void cancelNotification(View view) {
        // 取消通知
        mNotificationManager.cancel(1);
        // 获取执行结果
        boolean result = mNotificationManager.areNotificationsEnabled();
        Log.d("TAG", "cancelNotification: "+result);
        Toast.makeText(this,"取消通知",Toast.LENGTH_SHORT).show();
    }
}