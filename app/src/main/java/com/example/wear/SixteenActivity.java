package com.example.wear;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wear.databinding.ActivitySixteenBinding;

public class SixteenActivity extends Activity {

    private TextView mTextView;
    private ActivitySixteenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySixteenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        mTextView = binding.text;
    }
}