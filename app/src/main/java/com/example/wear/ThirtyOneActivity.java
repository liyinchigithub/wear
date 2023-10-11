package com.example.wear;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wear.databinding.ActivityThirtyOneBinding;

public class ThirtyOneActivity extends Activity {

    private TextView mTextView;
    private ActivityThirtyOneBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityThirtyOneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        mTextView = binding.text;
    }
}