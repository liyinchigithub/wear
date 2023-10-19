package com.example.wear;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wear.databinding.ActivityFifteenBinding;

/**
 * 登录
 * */
public class FifteenActivity extends Activity {

    private TextView mTextView;
    private ActivityFifteenBinding binding;
    private SharedPreferences sharedPrefs;// 保存用户信息
    private EditText accountEditText; // 账号输入框
    private EditText passwordEditText;// 密码输入框
    private CheckBox isRememberCheckbox;// 是否记住密码
    private String accountStr;//
    private String passwordStr;//
    private Boolean isRemember;// 是否记住密码
    private Button loginBtn;// 登录按钮
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFifteenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // 获取账号输入框
        accountEditText = findViewById(R.id.editTextAccount);
        // 获取密码输入框
        passwordEditText = findViewById(R.id.editTextPassword);
        // 获取记住密码复选框
        isRememberCheckbox = findViewById(R.id.checkboxRememberPassword);
        // 获取sharedPreferences对象
        sharedPrefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        // 获取sharePreferences对象 是否记住密码的值
        isRemember = sharedPrefs.getBoolean("isRemember", false);// 如果没有，取默认值false
        // 判断是否为true
        if (isRemember){
            String accountStr = sharedPrefs.getString("account", "");// 如果没有，取默认值空
            String passwordStr = sharedPrefs.getString("password", "");// 如果没有，取默认值空
            // 设置输入框账号的值
            accountEditText.setText(accountStr);
            // 设置输入框密码的值
            passwordEditText.setText(passwordStr);
            // 勾选记住密码
            isRememberCheckbox.setChecked(true);
            // 日志
            Log.d("FifteenActivity", "onCreate: "+accountStr+" "+passwordStr+" "+isRemember);
        }
        // 获取登录按钮
        loginBtn = findViewById(R.id.buttonLogin);
        // 监听登录按钮
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取账号和密码
                 accountStr = accountEditText.getText().toString();
                 passwordStr = passwordEditText.getText().toString();
                // 判断账号和密码是否为空
                if (TextUtils.isEmpty(accountStr) || TextUtils.isEmpty(passwordStr)){
                    Toast.makeText(FifteenActivity.this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                }
                // 判断账号和密码是否正确
                else if (!accountStr.equals("123") || !passwordStr.equals("456")){
                    Toast.makeText(FifteenActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                    Log.d("FifteenActivity", "onClick: 账号或密码错误");
                }
                // 判断账号和密码是否正确
                else {
                    Toast.makeText(FifteenActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    // 保存账号和密码
                    SharedPreferences.Editor editor = sharedPrefs.edit();
                    editor.putBoolean("isRemember", isRememberCheckbox.isChecked());// 存储是否记住账号密码
                    editor.putString("account", accountStr);// 存储账号
                    editor.putString("password", passwordStr);// 存储密码
                    editor.commit();//  提交
                    Log.d("TAG", "SavedSharedPreferences: " + sharedPrefs.getBoolean("isRemember", false));
                }

        }
    });


    }
}