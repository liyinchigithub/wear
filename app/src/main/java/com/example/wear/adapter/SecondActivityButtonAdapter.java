package com.example.wear.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wear.EighteenActivity;
import com.example.wear.EighthActivity;
import com.example.wear.ElevenActivity;
import com.example.wear.FifteenActivity;
import com.example.wear.FifthActivity;
import com.example.wear.FourteenActivity;
import com.example.wear.FourthActivity;
import com.example.wear.MainActivity;
import com.example.wear.NineActivity;
import com.example.wear.NineteenActivity;
import com.example.wear.SevenActivity;
import com.example.wear.SeventeenActivity;
import com.example.wear.SixteenActivity;
import com.example.wear.SixthActivity;
import com.example.wear.TenActivity;
import com.example.wear.ThirdActivity;
import com.example.wear.ThirteenActivity;
import com.example.wear.TwelveActivity;
import com.example.wear.TwentyActivity;
import com.example.wear.TwentyOneActivity;
import com.example.wear.TwentyTowActivity;
import com.example.wear.service.SensorService;
import com.example.wear.service.StepService;

/** 按钮适配器
 * 
 * 
 * 在Android开发中，Adapter（适配器）是一种设计模式，用于将"数据"和"用户界面组件"进行绑定，以便在用户界面中显示数据。
 *
 * Adapter主要用于将数据源（如数组、列表、数据库等）中的数据适配到用户界面的视图组件（如ListView、RecyclerView等）上。
 * 在你提供的代码中，SecondActivityButtonAdapter是一个RecyclerView的适配器。
 * 它的主要作用是将按钮的数据源（mButtonNames）适配到RecyclerView的每个item上。
 * 具体来说，适配器的功能包括：
 * 1. 创建ViewHolder：
 *      通过实现onCreateViewHolder方法，适配器创建并返回一个ViewHolder对象，用于保存每个item的视图组件。
 * 2. 绑定数据到视图：
 *      通过实现onBindViewHolder方法，适配器将数据源中的数据绑定到ViewHolder中的视图组件上。
 *      在这个方法中，可以根据position参数确定当前item的位置，并根据位置获取对应的数据。
 * 3. 获取数据数量：
 *      通过实现getItemCount方法，适配器返回数据源中的数据数量，用于确定RecyclerView需要显示多少个item。
 *      适配器的作用是将数据和视图进行连接，使得数据能够在用户界面中以适当的方式显示出来。
 *      通过适配器，可以实现数据的动态更新、点击事件的处理等功能，从而提供更好的用户体验。

*/
public class SecondActivityButtonAdapter extends RecyclerView.Adapter<SecondActivityButtonAdapter.ViewHolder> {
    // 按钮字符串数组
    private String[] mButtonNames;
    // 构造函数
    public SecondActivityButtonAdapter(String[] buttonNames) {
        // 传入按钮字符串数组
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
                    Intent intent = new Intent(v.getContext(), MainActivity.class);// v.getContext() 获取父布局的上下文 也就是 SecondActivity 而 MainActivity.class 就是跳转的页面
                    // 创建 Bundle 对象 用于传递数据
                    Bundle bundle = new Bundle();
                    // 将数据添加到 Bundle 对象中
                    bundle.putString("textSecondActivityToMainActivity1","测试传递数据1");
                    // 将 Bundle 对象添加到 Intent 对象中
                    intent.putExtras(bundle);
                    // 将字符串添加到 Intent 对象中
                    intent.putExtra("textSecondActivityToMainActivity2","测试传递数据2");
                    // 调用 startActivity 方法实现跳转
                    v.getContext().startActivity(intent);
                }
                // 判断是否点击第二个按钮
                if (position == 1) {
                    // 如果点击了第二个按钮，第二页跳转到第二个页面 通过 Intent 对象实现
                    Intent intent = new Intent(v.getContext(), NineActivity.class);// v.getContext() 获取父布局的上下文 也就是 SecondActivity
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
                // 判断是否点击第六个按钮
                if (position == 5) {
                    // 如果点击了第六个按钮，第二页跳转到第六个页面 通过 Intent 对象实现
                    Intent intent = new Intent(v.getContext(), SixthActivity.class);// v.getContext() 获取父布局的上下文 也就是 SecondActivity
                    v.getContext().startActivity(intent);
                }

                //  判断是否点击第七个按钮
                if (position == 6) {
                    /**
                     * 使用sharePreferences存储数据
                     * */
                    // 获取 SharedPreferences 对象
                    SharedPreferences sharedPreferences = v.getContext().getSharedPreferences("data", Context.MODE_PRIVATE);
                    // 获取 SharedPreferences.Editor 对象
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    // 添加数据
                    editor.putString("sharedPreferencesData1", "测试数据sharedPreferences");
                    editor.putInt("sharedPreferencesData2", 1);
                    editor.putBoolean("sharedPreferencesData3", true);
                    // 提交数据
                    editor.apply();
                }

                //  判断是否点击第八个按钮
                if(position == 7){
                    /**
                     * 使用sharePreferences读取数据
                     * */
                    // 获取 SharedPreferences 对象
                    SharedPreferences sharedPreferences = v.getContext().getSharedPreferences("data", Context.MODE_PRIVATE);
                    // 声明变量接收数据
                    String sharedPreferencesData1 = sharedPreferences.getString("sharedPreferencesData1", "");
                    int sharedPreferencesData2 = sharedPreferences.getInt("sharedPreferencesData2", 0);
                    boolean sharedPreferencesData3 = sharedPreferences.getBoolean("sharedPreferencesData3", false);
                    // 显示数据
                    Toast.makeText(v.getContext(), "sharedPreferencesData1: " + sharedPreferencesData1 + "\n" + "sharedPreferencesData2: " + sharedPreferencesData2 + "\n" + "sharedPreferencesData3: " + sharedPreferencesData3, Toast.LENGTH_SHORT).show();
                }

                //  判断是否点击第九个按钮
                if(position == 8){
                    // 跳转页面
                    Intent intent = new Intent(v.getContext(), SevenActivity.class);
                    v.getContext().startActivity(intent);

                }

                // 判断是否点击第十个按钮
                if(position == 9){
                    // 跳转页面
                    Intent intent = new Intent(v.getContext(), EighthActivity.class);
                    v.getContext().startActivity(intent);

                }

                // 判断是否点击第十一个按钮
                if(position == 10){
                    // 跳转页面
                    Intent intent = new Intent(v.getContext(), TenActivity.class);
                    v.getContext().startActivity(intent);
                }


                // 判断是否点击第十二个按钮
                if(position == 11){
                    // 跳转页面
                    Intent intent = new Intent(v.getContext(), ElevenActivity.class);
                    v.getContext().startActivity(intent);
                }


                // 判断是否点击第十三个按钮
                if(position == 12){
                    // 跳转页面
                    Intent intent = new Intent(v.getContext(), TwelveActivity.class);
                    v.getContext().startActivity(intent);
                }
                // 判断是否点击第十四个按钮
                if(position == 13){
                    // 跳转页面
                    Intent intent = new Intent(v.getContext(), ThirteenActivity.class);
                    v.getContext().startActivity(intent);
                }

                // 判断是否点击第十五个按钮
                if(position == 14){
                   // 获取传感器信息
                    // 创建 Intent 对象
                    Intent intent = new Intent(v.getContext(), FourteenActivity.class);
                    // 调用 startActivity 方法发起请求
                    v.getContext().startActivity(intent);
                }

                // 判断是否点击第十六个按钮
                if(position == 15){
                    // 获取步数
                    // 创建 Intent 对象
                    Intent intent = new Intent(v.getContext(), FifteenActivity.class);
                    // 调用 startActivity 方法发起请求
                    v.getContext().startActivity(intent);

                }

                // 判断是否点击第十七个按钮
                if(position == 16){
                    // 获取步数
                    // 创建 Intent 对象
                    Intent intent = new Intent(v.getContext(), SixteenActivity.class);
                    // 调用 startActivity 方法发起请求
                    v.getContext().startActivity(intent);

                }

                // 判断是否点击第十八个按钮
                if(position == 17){
                    // 获取步数
                    // 创建 Intent 对象
                    Intent intent = new Intent(v.getContext(), SeventeenActivity.class);
                    // 调用 startActivity 方法发起请求
                    v.getContext().startActivity(intent);

                }

                // 判断是否点击第十九个按钮
                if (position == 18){
                    // 创建 Intent 对象
                    Intent intent = new Intent(v.getContext(), EighteenActivity.class);
                    // 调用 startActivity 方法发起请求
                    v.getContext().startActivity(intent);
                }
                // 判断是否点击第二十个按钮
                if (position == 19){
                    // 创建 Intent 对象
                    Intent intent = new Intent(v.getContext(), NineteenActivity.class);
                    // 调用 startActivity 方法发起请求
                    v.getContext().startActivity(intent);
                }
                // 判断是否点击第二十一个按钮
                if (position == 20){
                    // 创建 Intent 对象
                    Intent intent = new Intent(v.getContext(), TwentyActivity.class);
                    // 调用 startActivity 方法发起请求
                    v.getContext().startActivity(intent);
                }
                // 判断是否点击第二十二个按钮
                if (position == 21){
                    // 创建 Intent 对象
                    Intent intent = new Intent(v.getContext(), TwentyOneActivity.class);
                    // 调用 startActivity 方法发起请求
                    v.getContext().startActivity(intent);
                }
                // 判断是否点击第二十三个按钮
                if (position == 22){
                        // 创建 Intent 对象
                        Intent intent = new Intent(v.getContext(), TwentyTowActivity.class);
                        // 调用 startActivity 方法发起请求
                        v.getContext().startActivity(intent);
                }
                // 判断是否点击第二十四个按钮
                if (position == 23){
                    // 创建 Intent 对象
                    Intent intent = new Intent(v.getContext(), TwentyTowActivity.class);
                    // 调用 startActivity 方法发起请求
                    v.getContext().startActivity(intent);
                }
                // 判断是否点击第二十五个按钮
                if (position == 24){
                    // 创建 Intent 对象
                    Intent intent = new Intent(v.getContext(), TwentyTowActivity.class);
                    // 调用 startActivity 方法发起请求
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
