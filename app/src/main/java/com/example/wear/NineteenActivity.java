package com.example.wear;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wear.databinding.ActivityNineteenBinding;

public class NineteenActivity extends Activity {

    private TextView mTextView;
    private ActivityNineteenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNineteenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTextView = binding.text;
    }
}