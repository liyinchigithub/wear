package com.example.wear;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.wear.databinding.ActivityEighthBinding;
import com.example.wear.util.MediaPlayerService;

public class EighthActivity extends Activity {

    private TextView mTextView;
    private ActivityEighthBinding binding;
    /**
     * 当 Activity 被创建时，这个方法会被调用
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityEighthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTextView = binding.text;

        // 调用MediaPlayerService 这个service组件
        bindService(new Intent(this, MediaPlayerService.class), null, BIND_AUTO_CREATE);
        // 日志输出
        Log.d("EighthActivity", "onCreate");
    }
    /**
     *  当Activity 被可见时，这个方法会被调用
     * */
    @Override
    protected void onStart() {
        super.onStart();
        mTextView.setText("发生异常保存数据");
        // 日志输出
        Log.d("EighthActivity", "onStart");
    }

    /**
     * 当 Activity 被重新
     * */
    @Override
    protected void onResume() {
        super.onResume();
        // 日志输出
        Log.d("EighthActivity", "onResume");
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
        // 解除绑定
        unbindService(null);
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

    /**
     * 当 Activity 的配置信息发生改变时，这个方法会被调用
     * 例如：屏幕方向发生改变，键盘弹出，屏幕方向发生改变等
     *
     * */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // 判断屏幕方向
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // 横屏

        } else {
            // 竖屏
        }

        // 判断键盘是否弹出
        if (newConfig.hardKeyboardHidden == Configuration.KEYBOARDHIDDEN_NO) {

        }

        // 判断屏幕布局发生改变
        if (newConfig.screenLayout == Configuration.SCREENLAYOUT_SIZE_LARGE) {

        }

        // 判断屏幕的可用大小发生改变
        if (newConfig.screenWidthDp == Configuration.SCREENLAYOUT_SIZE_LARGE) {

        }

        // 判断UI模式发生改变
        if (newConfig.uiMode == Configuration.UI_MODE_TYPE_NORMAL) {

        }

        // 判断键盘类型
        if (newConfig.keyboard == Configuration.KEYBOARD_12KEY) {

        }
    }
}