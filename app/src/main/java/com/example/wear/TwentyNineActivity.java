package com.example.wear;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wear.databinding.ActivityTwentyNineBinding;

public class TwentyNineActivity extends Activity {

    private TextView mTextView;
    private ActivityTwentyNineBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTwentyNineBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        mTextView = binding.text;
    }
}