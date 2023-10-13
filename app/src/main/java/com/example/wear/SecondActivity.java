package com.example.wear;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wear.databinding.ActivitySecondBinding;

import com.example.wear.Adapter.SecondActivityButtonAdapter;

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
        // 布局文件中找到 RecyclerView 对象
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        // 设置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 设置适配器 用于显示按钮
        recyclerView.setAdapter(new SecondActivityButtonAdapter(new String[]{"返回0", "滚动条1", "定位2", "通知3", "唤起语音输入4", "数据同步5", "存储数据6", "获取数据7", "wifi开关", "音乐播放", "发送通知10", "顶栏底栏弹窗11", "广播12", "HTTP请求", "相机相册14", "sharePreferences15", "心率16", "步数17","加速器18","SQLite19","压力20","光度21","温度22","ContentProvider23","BroadcastReceiver24","智能语音25","service26","Activity通信27","28","广播29","30","31","32"}));
        // 添加按钮点击监听器
        recyclerView.addOnItemTouchListener(new ButtonClickListener(this));
        // 设置列表背景颜色
//        recyclerView.setBackgroundResource(R.drawable.list_background);
        // 获取布局文件中的元素
//        mTextView = binding.text;
        // DoKit.Builder 初始化 DoKit 对象
//        DoKit.Builder(this)
//                .productId("")
//                .build();


    }


    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}