package com.example.wear;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wear.databinding.ActivitySecondBinding;

import com.example.wear.adapter.SecondActivityButtonAdapter;

public class SecondActivity extends Activity {

    private TextView mTextView;
    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 调用了父类的 onCreate 方法
        super.onCreate(savedInstanceState);
        // ActivityMainBinding.inflate 方法初始化了 binding 对象
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        // setContentView 方法设置了 Activity 的布局
        setContentView(binding.getRoot());
        // 找到 RecyclerView 对象
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        // 设置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 设置适配器 用于显示按钮
        recyclerView.setAdapter(new SecondActivityButtonAdapter(new String[]{"返回0", "Button1", "定位2", "通知3", "唤起语音输入4", "数据同步5", "存储数据6", "获取数据7", "wifi开关", "http请求9", "获取联系人10", "获取位置11", "获取天气12", "获取系统信息13", "获取网络信息14", "获取传感器信息15", "获取步数16"}));
        // 添加按钮点击监听器
        recyclerView.addOnItemTouchListener(new ButtonClickListener(this));

        // 设置列表背景颜色
        recyclerView.setBackgroundResource(R.drawable.button_background);
//        mTextView = binding.text;
    }


    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}