package com.example.wear.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.wear.R;

import java.util.List;

/**
 *  适配器用于适配器类来管理列表中的数据项
 * */
public class ElevenActivityButtonAdapter extends RecyclerView.Adapter<ElevenActivityButtonAdapter.ButtonViewHolder> {

    private List<String> buttonList;

    public ElevenActivityButtonAdapter(List<String> buttonList) {
        this.buttonList = buttonList;
    }

    @NonNull
    @Override
    public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_button, parent, false);
        return new ButtonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonViewHolder holder, int position) {
        //  获取当前按钮的位置
        String buttonText = buttonList.get(position);
        holder.button.setText(buttonText);//

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 根据按钮的位置或文本来确定点击了哪个按钮
                if (position == 0) {
                    // 点击了第一个按钮
                    // 执行相应的操作
                } else if (position == 1) {
                    // 点击了第二个按钮
                    // 执行相应的操作
                } else if (position == 2) {
                    // 点击了第三个按钮
                    // 执行相应的操作
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return buttonList.size();
    }

    public static class ButtonViewHolder extends RecyclerView.ViewHolder {
        Button button;

        public ButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button);
        }
    }
}