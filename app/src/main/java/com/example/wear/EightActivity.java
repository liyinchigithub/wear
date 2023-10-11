package com.example.wear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wear.databinding.ActivityEightBinding;
import com.example.wear.service.MediaPlayerService;

public class EightActivity extends Activity {

    private TextView mTextView;
    private Button mediaPlayerButton;
    private ActivityEightBinding binding;
    /**
     * 当 Activity 被创建时，这个方法会被调用
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityEightBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // 获取布局元素
        mTextView = binding.text;
        mTextView.setText("播放音乐");
        // 日志输出
        Log.d("EighthActivity", "onCreate");

        // 获取布局按钮
        mediaPlayerButton = binding.mediaPlayerButton;
        // 监听按钮
        mediaPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 调用MediaPlayerService 这个service组件
                startService(new Intent(EightActivity.this, MediaPlayerService.class));
                // 日志输出
                Log.d("EighthActivity", "onClick");
            }
        });
    }
    /**
     *  当Activity 被可见时，这个方法会被调用
     * */
    @Override
    protected void onStart() {
        super.onStart();
        // 日志输出
        Log.d("EighthActivity", "onStart");
    }


    /**
     * 当Activity 可见时，这个方法会被调用
     * */
    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * 当 Activity 被暂停时，这个方法会被调用
     * */
    @Override
    protected void onPause() {
        super.onPause();
        // 日志输出
        Log.d("EighthActivity", "onPause");
    }

    /**
     * 当 Activity 被停止时，这个方法会被调用
     * */
    @Override
    protected void onStop() {
        super.onStop();
        // 日志输出
        Log.d("EighthActivity", "onStop");
    }

    /**
     * 当 Activity 被销毁时，这个方法会被调用
     * */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 日志输出
        Log.d("EighthActivity", "onDestroy");
        // 解除绑定Service
//       stopService(new Intent(this, MediaPlayerService.class));// activity销毁并同步销毁启动的MediaPlayerService组件
    }

    /**
     * 当 Activity 由于某种原因被销毁时，这个方法会被调用
     * 保存数据到 Bundle 对象中
     * */
   @Override
   public void onSaveInstanceState(Bundle outState) {
        // 调用父类的onSaveInstanceState方法
        super.onSaveInstanceState(outState);
        // 保存文本框的值
        outState.putString("text", mTextView.getText().toString());
        // 日志输出
        Log.d("EighthActivity", "onSaveInstanceState");

    }

    /**
     * 当 Activity 由于某种原因被销毁后，当用户再次打开这个 Activity 时，这个方法会被调用
     * 从 Bundle 对象中获取数据
     * */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // 调用父类的onRestoreInstanceState方法
        super.onRestoreInstanceState(savedInstanceState);
        // 获取保存的文本框的值
        String text = savedInstanceState.getString("text");
        // 设置文本框的值
        mTextView.setText(text);
        // 日志输出
        Log.d("EighthActivity", "onRestoreInstanceState");
    }

}