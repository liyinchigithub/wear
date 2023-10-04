package com.example.wear.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
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
    private Context context;


    public ElevenActivityButtonAdapter(List<String> buttonList , Context context) {
        this.buttonList = buttonList;
        this.context = context;
    }


    /**
     * onCreateViewHolder 用于创建ViewHolder
     * */
    @NonNull
    @Override
    public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("ButtonAdapter", "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_button, parent, false);
        return new ButtonViewHolder(view);
    }

    /**
     * onBindViewHolder 绑定数据
     * */
    @Override
    public void onBindViewHolder(@NonNull ButtonViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //  获取当前按钮的位置
        String buttonText = buttonList.get(position);
        // 将数据绑定到button
        holder.button.setText(buttonText);//

    }

    /**
     * getItemCount 显示多少个item
     * */
    @Override
    public int getItemCount() {
        return buttonList==null?0:buttonList.size();
    }


    public static class ButtonViewHolder extends RecyclerView.ViewHolder {
        Button button;

        public ButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            //
            button = itemView.findViewById(R.id.button);
            // 列表item点击事件监听
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 执行相应的操作
                    Log.d("ButtonAdapter", "点击了按钮");
                    //
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(v, getAdapterPosition());
                    }
                }
            });
        }
    }

    // 定义
    private static
    OnItemClickListener onItemClickListener;
    //
    public
    void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    /**
     * 创建接口，用于实现列表item点击事件
     * */
    public interface OnItemClickListener {
        //
        void onItemClick(View v, int position);
    }
}