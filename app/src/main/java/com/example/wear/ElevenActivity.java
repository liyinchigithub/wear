package com.example.wear;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wear.adapter.ElevenActivityButtonAdapter;
import com.example.wear.databinding.ActivityElevenBinding;

import java.util.ArrayList;

public class ElevenActivity extends AppCompatActivity {

    private ActivityElevenBinding binding;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleven);
        // 顶栏
        toolbar = findViewById(R.id.toolbar);//
//        toolbar.setTitle("MyToolbar");// 设置
//        toolbar.setSubtitle("子标题");
        toolbar.setLogo(R.drawable.ic_logo);
        toolbar.setBackground(getDrawable(R.color.colorPrimary));
        toolbar.setNavigationIcon(R.drawable.ic_back);
        // 监听左边返回按钮
        toolbar.setNavigationOnClickListener
                (new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("NavigationIcon", "NavigationIcon被点击了");
                        // 返回上一页
                        finish();
                    }
                });
        // 列表按钮
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        // 定义
        ArrayList<String> buttonList = new ArrayList<>();
        buttonList.add("按钮1");
        buttonList.add("按钮2");
        buttonList.add("按钮3");
        buttonList.add("按钮4");
        // 适配器
        ElevenActivityButtonAdapter adapter = new ElevenActivityButtonAdapter(buttonList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //
        adapter.setOnItemClickListener(new ElevenActivityButtonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
//                Toast.makeText(ElevenActivity.this, "你点击了" + position, Toast.LENGTH_SHORT).show();
                Log.d("onItemClick", "onItemClick");

                // 根据按钮的位置或文本来确定点击了哪个按钮
                switch (position) {
                    case 0:
                        // 点击了第一个按钮
                        // 执行相应的操作
                        // 弹出Dialog
                        Log.d("ButtonAdapter", "点击了第一个按钮");
                        AlertDialog
                                .Builder builder = new AlertDialog.Builder(v.getContext());
                        builder.setTitle("提示");
                        builder.setMessage("确定要退出吗？");
                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 点击了确定按钮
                                // 执行相应的操作
                                Log.d("ButtonAdapter", "点击了确定按钮");
                            }
                        });
                        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 点击了取消按钮
                                // 执行相应的操作
                                Log.d("ButtonAdapter", "点击了取消按钮");
                            }
                        });
                        // 显示弹窗
                        builder.create().show();
                        break;
                    case 1:
                        // 点击了第二个按钮
                        // 执行相应的操作
                        Log.d("ButtonAdapter", "点击了第二个按钮");
                        break;
                    case 2:
                        // 点击了第三个按钮
                        // 执行相应的操作
                        Log.d("ButtonAdapter", "点击了第三个按钮");
                        break;
                    default:
                        Log.d("ButtonAdapter", "点击了其他按钮");
                        break;
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    /**
     * 底栏按钮
     */
    public void goToHomePage(View view) {

    }

    /**
     *
     */
    public void goToSecondPage(View view) {

    }

    /**
     *
     */
    public void goToThirdPage(View view) {

    }
}