package com.example.wear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wear.databinding.ActivityTwentySevenBinding;

import dao.MyObject;

public class TwentySevenActivity extends Activity {

    private TextView mTextView;
    private ActivityTwentySevenBinding binding;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTwentySevenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        mTextView = binding.text;

        // Activity之间传递传参数
        intent = new Intent(TwentySevenActivity.this, TwentyEightActivity.class);
        intent.putExtra("li", "27发给28"); // 使用键值对的形式设置参数
        startActivity(intent);


//        MyObject object1 = new MyObject("John1", 25);
//        MyObject object2 = new MyObject("John2", 30);
//        intent = new Intent(TwentySevenActivity.this, TwentyEightActivity.class);
//        intent.putExtra("key1", object1);
//        intent.putExtra("key2", object2);
//        startActivity(intent);


    }
}