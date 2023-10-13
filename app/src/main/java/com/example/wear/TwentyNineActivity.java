package com.example.wear;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.wear.Broadcast.ActionUtils;
import com.example.wear.Broadcast.DyCustomerReceiver;
import com.example.wear.databinding.ActivityTwentyNineBinding;

import java.util.ArrayList;

public class TwentyNineActivity extends Activity {

    private TextView mTextView;
    private ActivityTwentyNineBinding binding;
    private DyCustomerReceiver  dyCustomerReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTwentyNineBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        mTextView = binding.text;

        // 动态注册广播
        dyCustomerReceiver = new DyCustomerReceiver();
        IntentFilter intentFilter = new IntentFilter();// 过滤
        intentFilter.addAction(ActionUtils.ACTION_DY_FLAG);
        registerReceiver(dyCustomerReceiver, intentFilter);
    }


    /**
     * 静态注册广播，布局按钮点击事件
     *
     * 静态发送广播 发送给 注册过这个广播的接收者
     *
     * */
    public void sendStaticBroadcast(View view) {
        Intent intent = new Intent();
        intent.putExtra("customer", "liyinchi");
        intent.setAction(ActionUtils.ACTION_FLAG);// 与注册时保持一致
        Log.d("TAG", "sendStaticBroadcast: ");
        sendBroadcast(intent);

    }
    /**
     * 动态注册广播，布局按钮点击事件
     *
     * 发送广播 发送给 注册过这个广播的接收者
     * */
    public void sendDynamicBroadcast(View view) {
        //
        Intent intent = new Intent();
        intent.putExtra("customer1", "liyinchi1111");
        // 放入数组数据到意图中
        intent.putStringArrayListExtra("customer",  new ArrayList<String>(){
            {
                add("liyinchi1");
                add("liyinchi2");

                /**
                 * 相当于
                 * {
                 *     "customer":[
                 *          "liyinchi1",
                 *          "liyinchi2"
                 *     ]
                 * }
                 *
                 * */
            }
        });
        intent.setAction(ActionUtils.ACTION_DY_FLAG);// 与注册时保持一致
        sendBroadcast(intent);// 发送广播
        Log.d("TAG", "sendDynamicBroadcast");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(dyCustomerReceiver);// 注销广播

    }
}