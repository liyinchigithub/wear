package com.example.wear;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wear.databinding.ActivitySecondBinding;

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
        recyclerView.setAdapter(new SecondActivityButtonAdapter(new String[] {"Button1", "Button2", "Button3", "Button4"}));
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