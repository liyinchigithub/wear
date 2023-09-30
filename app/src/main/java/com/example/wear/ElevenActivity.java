package com.example.wear;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wear.adapter.ElevenActivityButtonAdapter;
import com.example.wear.databinding.ActivityElevenBinding;

import java.util.ArrayList;
import java.util.List;

public class ElevenActivity extends AppCompatActivity {

    private ActivityElevenBinding binding;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleven);

        toolbar = findViewById(R.id.toolbar);

//        toolbar.setTitle("MyToolbar");//
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
        List<String> buttonList = new ArrayList<>();
        buttonList.add("按钮1");
        buttonList.add("按钮2");
        buttonList.add("按钮3");
        ElevenActivityButtonAdapter adapter = new ElevenActivityButtonAdapter(buttonList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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