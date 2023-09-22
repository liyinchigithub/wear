package com.example.wear;

import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// 按钮点击事件监听
public class ButtonClickListener implements RecyclerView.OnItemTouchListener {
    public ButtonClickListener(SecondActivity secondActivity) {
        // 写一个显示toast
        secondActivity.showToast("点击了登录按钮");
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
