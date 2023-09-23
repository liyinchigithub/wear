package com.example.wear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wear.databinding.ActivityFifthBinding;

import java.util.ArrayList;
import java.util.Locale;

public class FifthActivity extends Activity {

    private TextView mTextView;
    private ActivityFifthBinding binding;
    private static final int REQ_CODE_SPEECH_INPUT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 调用了父类的 onCreate 方法
        super.onCreate(savedInstanceState);
        // 初始化binding对象，用于处理布局的绑定
        binding = ActivityFifthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTextView = binding.text;

        // 启动语音输入
        promptSpeechInput();
    }

    /**
     * 显示谷歌语音输入对话框以提示用户进行语音输入
     */
    private void promptSpeechInput() {
        // 创建一个语音识别意图
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        // 设置语音识别模式
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        // 设置语言
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        // 设置提示语
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "请说话");

        try {
            // 启动语音识别意图
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (Exception e) {
            // 如果语音识别意图启动失败，提示用户
            Toast.makeText(getApplicationContext(), "抱歉，您的设备不支持语音输入", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 接收语音输入结果并处理
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // 调用父类的 onActivityResult 方法
        super.onActivityResult(requestCode, resultCode, data);
        // 如果请求码是语音输入请求码
        switch (requestCode) {
            // 如果结果码是成功的
            case REQ_CODE_SPEECH_INPUT: {
                // 如果数据不为空
                if (resultCode == RESULT_OK && null != data) {
                    // 获取语音输入结果
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    // 将语音输入结果显示在文本视图中
                    mTextView.setText(result.get(0));
                }
                break;
            }
        }
    }
}