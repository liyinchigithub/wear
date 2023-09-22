package com.example.wear;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
// 按钮适配器
public class SecondActivityButtonAdapter extends RecyclerView.Adapter<SecondActivityButtonAdapter.ViewHolder> {
    // 声明按钮字符串数组
    private String[] mButtonNames;
    // 构造函数 初始化按钮字符串数组
    public SecondActivityButtonAdapter(String[] buttonNames) {
        mButtonNames = buttonNames;
    }

    // 创建 ViewHolder用于保存每个按钮
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 创建按钮
        Button button = new Button(parent.getContext());
        // 设置按钮布局参数
        button.setLayoutParams(new ViewGroup.LayoutParams(
                // 宽度为父布局宽度
                ViewGroup.LayoutParams.MATCH_PARENT,
                // 高度为包裹内容
                ViewGroup.LayoutParams.WRAP_CONTENT));
        // 返回 ViewHolder对象
        return new ViewHolder(button);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // 要判断点击了哪个按钮，你可以在onBindViewHolder方法中为每个按钮设置一个点击监听器。
        // 在这个监听器中，你可以使用position参数来确定点击了哪个按钮。
        holder.mButton.setText(mButtonNames[position]);
        holder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 在这里，你可以使用position参数来确定点击了哪个按钮
                Log.d("SecondActivityButtonAdapter", "Clicked button at position: " + position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mButtonNames.length;
    }


    // ViewHolder类
    static class ViewHolder extends RecyclerView.ViewHolder {
        Button mButton;

        ViewHolder(Button button) {
            super(button);
            mButton = button;
        }
    }

}
