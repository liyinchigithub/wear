package com.example.wear;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wear.databinding.ActivitySevenBinding;

public class SevenActivity extends Activity {

    private TextView mTextView;
    private ActivitySevenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 加载布局
        super.onCreate(savedInstanceState);
        // 加载布局
        setContentView(R.layout.activity_seven);
        // 初始化binding对象，用于处理布局的绑定
        binding = ActivitySevenBinding.inflate(getLayoutInflater());
        // 修改text_wifi文本
        binding.textWifi.setText("开关");
        // 监听switch_wifi开关
        findViewById(R.id.switch_wifi).setOnClickListener(v -> {
            // 判断开关状态
            if (binding.switchWifi.isChecked()==true) {
                // 如果开关打开，显示开启
                binding.title.setText("开启");
                // toast 消息
                Toast.makeText(SevenActivity.this, "开启", Toast.LENGTH_SHORT).show();
            } else {
                // 如果开关关闭，显示关闭
                binding.title.setText("关闭");
                // toast 消息
                Toast.makeText(SevenActivity.this, "关闭", Toast.LENGTH_SHORT).show();
            }
        });

    }
}