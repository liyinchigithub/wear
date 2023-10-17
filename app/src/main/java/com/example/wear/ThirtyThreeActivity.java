package com.example.wear;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.RemoteException;
import android.widget.TextView;


import com.example.wear.databinding.ActivityThirtyThreeBinding;

import java.io.File;

public class ThirtyThreeActivity extends Activity {

    private TextView mTextView;
    private ActivityThirtyThreeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityThirtyThreeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTextView = binding.text;


    }
    private String getSDCardDir(Context context) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File sdcardDir = context.getExternalFilesDir(null);
            if (sdcardDir != null) {
                return sdcardDir.toString();
            }
        }
        return null;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}