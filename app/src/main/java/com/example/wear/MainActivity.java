package com.example.wear;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.wear.databinding.ActivityMainBinding;

// MainActivity类继承了 Android 的 Activity 类。
// Activity 是 Android 应用的一个基本组成部分，每个 Activity 都代表了用户界面的一个屏幕
public class MainActivity extends AppCompatActivity { // AppCompatActivity 是 Activity 的子类，它是一个向后兼容的 Activity 类，它提供了向后兼容的功能，允许你使用较新的 API 版本来编译应用，同时仍然可以在较旧的 Android 设备上运行。
    // 用于显示文本
    private TextView mTextView;
    // 用于处理布局的绑定
    private ActivityMainBinding binding;
    // 用于显示按钮
    private Button loginButton;

    // 当 Activity 被创建时，这个方法会被调用
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * 将布局文件加载到Activity中
         * */
        // 调用父类onCreate方法
        super.onCreate(savedInstanceState);
        // 初始化binding对象，用于处理布局的绑定
        binding = ActivityMainBinding.inflate(getLayoutInflater());// 将一个 XML 布局文件转换（或填充）成相应的视图对象。例如，当你调用 ActivityMainBinding.inflate(getLayoutInflater())，你实际上是在将 ActivityMain 的 XML 布局文件解析成一个可以在代码中操作的 ActivityMainBinding 对象。
        // 加载布局让用户看到界面
        setContentView(R.layout.activity_main);

        /**
         * 获取TextView对象
         * */
        // 第一种方式：通过 binding 对象找到activity_main.xml中 text 对象
        mTextView = binding.title;
        // 第二种方式：通过 findViewById 方法找到布局文件布局activity_main.xml 中的 text 对象
        mTextView = findViewById(R.id.title);
        // 获取文本
        String text = mTextView.getText().toString();
        Log.d("MainActivity", "text:" + text);


        /**
         * 在activity中添加Fragment
         * */
        FragmentOne fragment = new FragmentOne();
        // 通过FragmentManager对象获取FragmentTransaction对象
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        // 将新的ExampleFragment添加到容器中。R.id.fragment_container是容器的ID，fragment是要添加的Fragment。
        fragmentTransaction.add(R.id.fragment_one, fragment);

        // 提交事务。这会立即执行事务，除非你之前调用了addToBackStack，那么事务会在调用commit后的某个时间点执行。
        fragmentTransaction.commit();
    }

    /**
     * 当Activity可见时，这个方法会被调用
     */
    @Override
    protected void onStart() {
        super.onStart();
        // 初始化mTextView 对象。
        // mTextView = binding.text;
        // 初始化-账号输入框对象
        binding.account.setText("");// 通过 binding 对象找到activity_main.xml中 account 对象，然后调用 setText 方法设置文本
        // 初始化-密码输入框对象
        binding.password.setText("");

    }

    /**
     * 当Activity与用户进行交互时，获取焦点时，这个方法会被调用
     */
    @Override
    protected void onResume() {
        super.onResume();

        // 登录按钮
        Button loginButton = findViewById(R.id.button_text_login);// 找到布局文件布局activity_main.xml 中的 button_text_login 对象
        // 点击事件监听器
        loginButton.setOnClickListener(new View.OnClickListener() {
            // 这里是点击按钮时要执行的代码
            @Override
            public void onClick(View v) {
                // 获取账号输入框的值
                String account = ((EditText) findViewById(R.id.account)).getText().toString();
                String password = ((EditText) findViewById(R.id.password)).getText().toString();
                // 判断账号密码输入框的值
                if ("123".equals(account) && password.equals("456")) {
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

        // 长按事件
        loginButton.setOnLongClickListener(new View.OnLongClickListener() {
            // 这里是长按按钮时要执行的代码
            @Override
            public boolean onLongClick(View v) {
                // 显示 Toast 消息
                Toast.makeText(MainActivity.this, "长按登录按钮", Toast.LENGTH_SHORT).show();
                Log.d("MainActivity", "长按登录按钮");
                return false;
            }
        });

        // 触摸事件
        loginButton.setOnTouchListener(new View.OnTouchListener() {
            // 这里是触摸按钮时要执行的代码
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 显示 Toast 消息
                Toast.makeText(MainActivity.this, "触摸登录按钮", Toast.LENGTH_SHORT).show();
                Log.d("MainActivity", "触摸登录按钮");
                Log.d("MainActivity", "触摸事件：" + event.getAction());
                return true;
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

    /**
     * 当Activity失去焦点时，这个方法会被调用
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * 当Activity不可见时，这个方法会被调用
     */
    @Override
    protected void onStop() {
        super.onStop();
    }

    /**
     * 当Activity被销毁时，这个方法会被调用
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}

