package com.example.wear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wear.databinding.ActivityMainBinding;

// 继承了 Android 的 Activity 类。Activity 是 Android 应用的一个基本组成部分，每个 Activity 都代表了用户界面的一个屏幕
public class MainActivity extends Activity {
    // 用于显示文本
    private TextView mTextView;
    // 用于处理布局的绑定
    private ActivityMainBinding binding;
    // 用于显示按钮
    private Button mButtonShow;
    // 当 Activity 被创建时，这个方法会被调用
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 调用了父类的 onCreate 方法
        super.onCreate(savedInstanceState);
        // 初始化binding对象，用于处理布局的绑定
        binding = ActivityMainBinding.inflate(getLayoutInflater());// 将一个 XML 布局文件转换（或填充）成相应的视图对象。例如，当你调用 ActivityMainBinding.inflate(getLayoutInflater())，你实际上是在将 ActivityMain 的 XML 布局文件解析成一个可以在代码中操作的 ActivityMainBinding 对象。
        // setContentView 方法设置了 Activity 的布局
        setContentView(R.layout.activity_main);
        // 初始化mTextView 对象。
//        mTextView = binding.text;
        // 初始化账号输入框对象
        binding.account.setText("123");// 通过 binding 对象找到activity_main.xml中 account 对象，然后调用 setText 方法设置文本
        // 初始化密码输入框对象
        binding.password.setText("456");
        // 初始化显示按钮对象
        mButtonShow = findViewById(R.id.button_text_login);
        // 设置按钮点击事件监听器
        mButtonShow.setOnClickListener(new View.OnClickListener() {
            // 这里是点击按钮时要执行的代码
            @Override
            public void onClick(View v) {
                // 判断账号密码是否正确
                if (binding.account.getText().toString().equals("123") && binding.password.getText().toString().equals("456")) {
                    // 如果账号密码正确，跳转到第二个页面 通过 Intent 对象实现
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }else{
                    // 例如，你可以显示一个 Toast 消息：
                    Toast.makeText(MainActivity.this, "请输入账号密码", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}