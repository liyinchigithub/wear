package com.example.wear;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

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
        Button button = new Button(parent.getContext());// parent.getContext() 获取父布局的上下文 也就是 SecondActivity
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
                // 显示一个 Toast 消息：
                Toast.makeText(v.getContext(), "Clicked button at position: " + position, Toast.LENGTH_SHORT).show();
                // 判断是否点击第一个按钮
                if (position == 0) {
                    // 如果点击了第一个按钮，第二页跳转到第一个页面 通过 Intent 对象实现
                    Intent intent = new Intent(v.getContext(), MainActivity.class);// v.getContext() 获取父布局的上下文 也就是 SecondActivity
                    v.getContext().startActivity(intent);
                }
                // 判断是否点击第三个按钮
                if (position == 2) {
                    // 如果点击了第三个按钮，第二页跳转到第三个页面 通过 Intent 对象实现
                    Intent intent = new Intent(v.getContext(), ThirdActivity.class);// v.getContext() 获取父布局的上下文 也就是 SecondActivity
                    v.getContext().startActivity(intent);
                }
                // 判断是否点击第四个按钮
                if (position == 3) {
                    // 如果点击了第四个按钮，第二页跳转到第四个页面 通过 Intent 对象实现
                    Intent intent = new Intent(v.getContext(), FourthActivity.class);// v.getContext() 获取父布局的上下文 也就是 SecondActivity
                    v.getContext().startActivity(intent);
                }
                // 判断是否点击第五个按钮
                if (position == 4) {
                    // 如果点击了第五个按钮，第二页跳转到第五个页面 通过 Intent 对象实现
                    Intent intent = new Intent(v.getContext(), FifthActivity.class);// v.getContext() 获取父布局的上下文 也就是 SecondActivity
                    v.getContext().startActivity(intent);
                }
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
