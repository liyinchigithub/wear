package com.example.wear;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wear.databinding.ActivityTwentyTowBinding;

public class TwentyTowActivity extends Activity {

    private TextView mTextView;
    private ActivityTwentyTowBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTwentyTowBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTextView = binding.text;
    }
}