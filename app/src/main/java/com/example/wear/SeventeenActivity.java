package com.example.wear;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

import com.example.wear.databinding.ActivitySevenBinding;
import com.example.wear.databinding.ActivitySeventeenBinding;
import com.example.wear.databinding.ActivityTwentyBinding;
// 步数传感器
public class SeventeenActivity extends WearableActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor stepSensor;
    private TextView stepCountTextView;
    private ActivitySeventeenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventeen);

        // 初始化视图
        stepCountTextView = findViewById(R.id.text);

        // 获取传感器管理器实例
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // 获取步数传感器实例
        stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        // 注册传感器监听器
        sensorManager.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            float steps = event.values[0];
            stepCountTextView.setText("步数：" + steps);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // 不需要实现
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 取消注册传感器监听器
        sensorManager.unregisterListener(this);
    }
}