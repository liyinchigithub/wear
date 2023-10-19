package com.example.wear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.wear.databinding.ActivityTwentyEightBinding;

import dao.MyObject;

/**
 * activity 通信传参（接收其他页面传过来的参数）
 * */
public class TwentyEightActivity extends Activity {

    private TextView mTextView;
    private ActivityTwentyEightBinding binding;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTwentyEightBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        mTextView = binding.twenty_eight_text;
        // 接收TwentySevenActivity发过来的参数
        intent = getIntent();
        if (intent != null){
            String value = intent.getStringExtra("li"); // 使用键值对的形式获取参数
            Log.d("TwentyEightActivity li", value);
            binding.twentyEightText.setText(value);
        }else{
            binding.twentyEightText.setText("没有收到27发过来的数据");
        }

//        MyObject object1 = (MyObject) intent.getSerializableExtra("key1");
//        Log.d("SenderActivity", "Object1: " + object1); // 检查对象是否为null
//        String name1 = object1.getName();
//        int age1 = object1.getAge();
//        Log.d("name1", name1);
//        Log.d("age1", String.valueOf(age1));

//        MyObject object2 = (MyObject) intent.getSerializableExtra("key2");
//        Log.d("SenderActivity", "Object2: " + object2); // 检查对象是否为null
//        String name2 = object2.getName();
//        int age2 = object2.getAge();
//        Log.d("nam2", name2);
//        Log.d("age2", String.valueOf(age2));

    }
}