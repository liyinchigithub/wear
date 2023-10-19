package com.example.wear;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import com.example.wear.databinding.ActivitySeventeenBinding;

/**
 * 传感器
 * 加速度传感器
 * */
public class EighteenActivity extends WearableActivity {

    private static final String TAG = "EighteenActivity";
    private static final int REQUEST_PERMISSIONS = 1;

    private SensorManager sensorManager;
    private Sensor stepSensor;
    private Sensor accelerometerSensor;
    private ActivitySeventeenBinding binding;
    private SensorEventListener stepListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float steps = event.values[0];
            Log.d(TAG, "Steps: " + steps);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // 当传感器的精度发生变化时回调
        }
    };

    private SensorEventListener accelerometerListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            Log.d(TAG, "Accelerometer: x=" + x + ", y=" + y + ", z=" + z);
            TextView text_x= findViewById(R.id.text_x);
            TextView text_y= findViewById(R.id.text_y);
            TextView text_z= findViewById(R.id.text_z);
            text_x.setText("x="+x);
            text_y.setText("y="+y);
            text_z.setText("z="+z);

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // 当传感器的精度发生变化时回调
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eighteen);

        // 获取 SensorManager 的实例
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // 获取步数传感器
        stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        // 获取加速度传感器
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // 检查权限
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACTIVITY_RECOGNITION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACTIVITY_RECOGNITION}, REQUEST_PERMISSIONS);
        } else {
            registerSensorListeners();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerSensorListeners();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterSensorListeners();
    }

    private void registerSensorListeners() {
        // 注册步数传感器监听器
        if (stepSensor != null) {
            sensorManager.registerListener(stepListener, stepSensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            Log.d(TAG, "Step sensor not available");
        }

        // 注册加速度传感器监听器
        if (accelerometerSensor != null) {
            sensorManager.registerListener(accelerometerListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            Log.d(TAG, "Accelerometer sensor not available");
        }
    }

    private void unregisterSensorListeners() {
        sensorManager.unregisterListener(stepListener);
        sensorManager.unregisterListener(accelerometerListener);
    }
}