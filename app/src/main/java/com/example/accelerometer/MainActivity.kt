package com.example.accelerometer

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textview = findViewById<TextView>(R.id.textview)
        var sm = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        var list = sm.getSensorList(Sensor.TYPE_ACCELEROMETER)
        var se = object : SensorEventListener{
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

            }

            override fun onSensorChanged(sensorEvent: SensorEvent?) {
                var values = sensorEvent!!.values
                var x = values.get(0)
                var y = values.get(1)
                var z = values.get(2)
                textview.setText("X=$x\nY=$y\nZ=$z")

            }
        }
        sm.registerListener(se, list.get(0), SensorManager.SENSOR_DELAY_NORMAL)
    }
}