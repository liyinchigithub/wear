package com.example.wear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    private Button loginButton;
    // 当 Activity 被创建时，这个方法会被调用
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 调用父类onCreate方法
        super.onCreate(savedInstanceState);
        // 初始化binding对象，用于处理布局的绑定
        binding = ActivityMainBinding.inflate(getLayoutInflater());// 将一个 XML 布局文件转换（或填充）成相应的视图对象。例如，当你调用 ActivityMainBinding.inflate(getLayoutInflater())，你实际上是在将 ActivityMain 的 XML 布局文件解析成一个可以在代码中操作的 ActivityMainBinding 对象。
        // 加载布局让用户看到界面
        setContentView(R.layout.activity_main);

    }


    // onStart
    @Override
    protected void onStart() {
        super.onStart();
        // 初始化mTextView 对象。
        // mTextView = binding.text;
        // 初始化-账号输入框对象
        binding.account.setText("123");// 通过 binding 对象找到activity_main.xml中 account 对象，然后调用 setText 方法设置文本
        // 初始化-密码输入框对象
        binding.password.setText("456");
        // 初始化-显示按钮对象
        loginButton = findViewById(R.id.button_text_login);// 找到布局文件布局activity_main.xml 中的 button_text_login 对象
        // 设置按钮点击事件监听器
        loginButton.setOnClickListener(new View.OnClickListener() {
            // 这里是点击按钮时要执行的代码
            @Override
            public void onClick(View v) {
                // 获取用户输入框输入的值
                String account = binding.account.getText().toString();
                String password = binding.password.getText().toString();

                // 判断账号密码输入框的值
                if (account.equals("123") && password.equals("456")) {
                    // 创建一个 Intent 对象，用于跳转到 SecondActivity
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    // 创建一个 Bundle 对象，用于传递数据
                    Bundle bundle = new Bundle();
                    // 将字符串数据放入 Bundle 对象
                    bundle.putString("textMainActivityToSecondActivity1", "Hello SecondActivity");
                    // 日志输出输入框的值
                    Log.d("MainActivity", "账号：" + account + "密码：" + password);
                    // 将 Bundle 对象放入 Intent 对象
                    intent.putExtras(bundle);
                    // 跳转到 SecondActivity
                    startActivity(intent);
                } else {
                    // 显示 Toast 消息
                    Toast.makeText(MainActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                    // 日志输出输入框的值
                    Log.d("MainActivity", "账号：" + account + "密码：" + password);
                }
            }

        });

        // 获取传递过来的 Bundle 对象
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            // 通过 Bundle 对象获取字符串数据
            String text = bundle.getString("textSecondActivityToMainActivity1");
            // 在这里，你可以使用 text 变量
            // 例如，你可以显示一个 Toast 消息：
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }
    }
}

