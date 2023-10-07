package com.example.wear;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.wear.databinding.ActivityTwentyBinding;

// 使用光、压力和温度传感器
public class TwentyActivity extends Activity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor pressure;

    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twenty);

        // 获取传感器服务的实例，并使用它来获取特定传感器的实例。
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        pressure = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // 如果传感器的精度发生变化，可以在这里进行处理。
    }

    @Override
    public final void onSensorChanged(SensorEvent event) {
        float millibarsOfPressure = event.values[0];

        // 在这里处理传感器数据。
        Log.d("SensorTest", "Pressure: " + millibarsOfPressure);// 气压

        //
        ((TextView) findViewById(R.id.millibarsOfPressure)).setText("Pressure: " + millibarsOfPressure);
    }

    @Override
    protected void onResume() {
        // 注册传感器的监听器。
        super.onResume();
        sensorManager.registerListener(this, pressure, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        // 在活动暂停时取消注册传感器。
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}