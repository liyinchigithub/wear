package com.example.wear;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wear.databinding.ActivityTwentyFiveBinding;

import java.util.ArrayList;
import java.util.List;

public class TwentyFiveActivity extends Activity {

    private TextView mTextView;
    private ActivityTwentyFiveBinding binding;
    private static final int SPEECH_REQUEST_CODE = 1;
    private Button voiceInputButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTwentyFiveBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set up voice input button click listener
        voiceInputButton = binding.speechButton;//
        voiceInputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySpeechRecognizer();
            }
        });
    }
    /**
     * 显示语音识别器
     * */
    private void displaySpeechRecognizer() {
        // 检查设备是否支持语音识别
        PackageManager packageManager = getPackageManager();
        //  获取语音识别器
        List<ResolveInfo> activities = packageManager.queryIntentActivities(new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
        //
        if (activities.size() > 0) {
            // 创建语音识别意图
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            // 启动语音识别活动
            startActivityForResult(intent, SPEECH_REQUEST_CODE);
        } else {
            // 不支持语音识别，显示错误消息或切换到其他输入方法
            Toast.makeText(this, "此设备不支持语音识别", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            // Get the speech recognition results
            ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (results != null && !results.isEmpty()) {
                String spokenText = results.get(0);
                processSpeechInput(spokenText);
            }
        }
    }

    private void processSpeechInput(String spokenText) {
        // Process the spoken text and perform actions accordingly
        // ...
    }

    /**
     * 唤起智能语音
     * */
    public void onClick(View view) {


    }
}