package com.example.wear;

import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
// 按钮适配器
public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ViewHolder> {
    // 声明按钮字符串数组
    private String[] mButtonNames;
    // 构造函数 初始化按钮字符串数组
    public ButtonAdapter(String[] buttonNames) {
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mButton.setText(mButtonNames[position]);
    }

    @Override
    public int getItemCount() {
        return mButtonNames.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        Button mButton;

        ViewHolder(Button button) {
            super(button);
            mButton = button;
        }
    }

}
