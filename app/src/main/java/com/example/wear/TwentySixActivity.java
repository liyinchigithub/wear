package com.example.wear;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wear.databinding.ActivityTwentySixBinding;
import com.example.wear.service.NetworkService;

public class TwentySixActivity extends Activity {

    private TextView mTextView;
    private ActivityTwentySixBinding binding;
    private Button startButton;
    private Button stopButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTwentySixBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        startButton = binding.startServiceButton;
        stopButton = binding.stopServiceButton;
    }

    /**
     * 启动Service
     * */
    public void onClickStartService(View view) {
        // 启动服务
        startService(new Intent(this, NetworkService.class));
    }

    /**
     * 停止Service
     * */
    public void onClickStopService(View view) {
        // 停止服务
        stopService(new Intent(this, NetworkService.class));
    }

    /**
     * 绑定Service
     * */
    public void onClickBindService(View view) {
        /**
         * @param service 服务类
         * @param connection 连接activity和Service的桥梁
         * @param BIND_AUTO_CREATE  连接模式
         * */
        bindService(new Intent(this, NetworkService.class), mConnection, BIND_AUTO_CREATE);
    }

    /**
     * 解绑定Service
     * */
    public void onClickUnbindService(View view) {
        unbindService(mConnection);
    }

    /**
     * 定义一个connection成员方法，，使用BindService时使用
     * TwentySixActivity中定义的connection方法，用于连接TwentySixActivity和NetworkService
     * 对应NetworkService中的onBind方法，用于连接NetWorkService和TwentySixActivity
     * */
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

        @Override
        public void onBindingDied(ComponentName name) {
            ServiceConnection.super.onBindingDied(name);
        }

        @Override
        public void onNullBinding(ComponentName name) {
            ServiceConnection.super.onNullBinding(name);
        }
    };


}