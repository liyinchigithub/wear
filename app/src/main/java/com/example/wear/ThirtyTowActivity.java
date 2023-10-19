package com.example.wear;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.wear.Broadcast.ActionUtils;
import com.example.wear.databinding.ActivityThirtyTowBinding;

/**
 * 广播
 * 自定义广播-activity接收广播的传参
 * */
public class ThirtyTowActivity extends Activity {
    private TextView mTextView;
    private ActivityThirtyTowBinding binding;
    private BroadcastReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityThirtyTowBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // 布局元素
        mTextView = binding.text;
        // 创建BroadcastReceiver对象
        receiver = new BroadcastReceiver() {
            /**
             * 创建了一个匿名内部类，该类继承自BroadcastReceiver。
             * 这个匿名内部类覆盖了onReceive方法，这是所有广播接收器必须实现的方法。
             * 当接收到一个广播时，onReceive方法会被调用
             *
             * */
            @Override
            public void onReceive(Context context, Intent intent) {
                //  获取传递的参数
                String data = intent.getStringExtra("key");// onReceive方法从传入的Intent中获取了一个名为"key"的字符串数据。这个数据是在发送广播时通过putExtra方法添加到Intent中的。
                // 使用传递的参数进行操作
                Log.d("ThirtyTowActivity 接收到BroadcastReceiver发送过来的数据",data);

            }
        };

        // 注册BroadcastReceiver
        IntentFilter filter = new IntentFilter(ActionUtils.ACTION_BROADCAST_TO_ACTIVITY_FLAG);
        // 这个匿名内部类的实例被赋值给了receiver变量。
        // 然后，你可以使用LocalBroadcastManager的registerReceiver方法注册这个广播接收器，使其能够接收到特定的广播。
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, filter);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void  onDestroy(){
        super.onDestroy();
        // 取消注册BroadcastReceiver
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
        // 在onDestroy方法中，你需要使用LocalBroadcastManager的unregisterReceiver方法取消注册这个广播接收器，以防止内存泄漏。
    }

    public void sendBroadcast(View view) {
        // 发送广播
        Intent intent = new Intent(ActionUtils.ACTION_BROADCAST_TO_ACTIVITY_FLAG);
        intent.putExtra("key","我是来自ThirtyTowActivity的广播");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

    }
}