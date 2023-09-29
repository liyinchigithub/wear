package com.example.wear;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.wear.databinding.ActivityNineBinding;

public class NineActivity extends Activity {

    private TextView mTextView;
    private ActivityNineBinding binding;
    private ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNineBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTextView = binding.text;// 相当于findViewById(R.id.text);
        mTextView.setText("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");



    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void onButtonClick(View view) {
        mProgressBar = binding.progress;
        // 设置进度条的当前进度
        mProgressBar.setProgress(100);

        // 点击显示/隐藏进度条
        if (mProgressBar.getVisibility() == View.VISIBLE) {
            // 隐藏进度条
            mProgressBar.setVisibility(View.GONE);
        } else {
            // 显示进度条
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

}