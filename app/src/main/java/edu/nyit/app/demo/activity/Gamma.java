package edu.nyit.app.demo.activity;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

import edu.nyit.app.demo.R;

public class Gamma extends Activity implements SensorEventListener {

    protected SensorManager sensorManager;
    protected Sensor accelerometer;

    protected TextView tv_x ,tv_y, tv_z;

    float x, y, z;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamma);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    protected void onResume() {
        super.onResume();
        tv_x = (TextView) findViewById(R.id.gamma_x);
        tv_y = (TextView) findViewById(R.id.gamma_y);
        tv_z = (TextView) findViewById(R.id.gamma_z);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void updateHook() {
        tv_x.setText(String.format("%f", x));
        tv_y.setText(String.format("%f", y));
        tv_z.setText(String.format("%f", z));
    }

    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if(sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            x = event.values[0];
            y = event.values[1];
            z = event.values[2];
        }
        updateHook();
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
