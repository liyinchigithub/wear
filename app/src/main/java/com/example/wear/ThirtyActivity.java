package com.example.wear;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wear.databinding.ActivityThirtyBinding;

public class ThirtyActivity extends Activity {

    private TextView mTextView;
    private ActivityThirtyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityThirtyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        mTextView = binding.text;
    }
}