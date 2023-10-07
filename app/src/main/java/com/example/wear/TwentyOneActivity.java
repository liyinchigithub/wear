package com.example.wear;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wear.databinding.ActivityTwentyOneBinding;

public class TwentyOneActivity extends Activity {

    private TextView mTextView;
    private ActivityTwentyOneBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTwentyOneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTextView = binding.text;
    }
}