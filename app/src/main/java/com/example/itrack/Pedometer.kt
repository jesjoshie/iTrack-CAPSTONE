package com.example.itrack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Pedometer : AppCompatActivity()/*, SensorEventListener */{
    /*private var sensorManager: SensorManager? = null
    private var running = false
    private var totalSteps = 0f
    private var previousTotalSteps = 0f
    val tv_stepsTaken = findViewById<TextView>(R.id.tv_stepsTaken)
    val progress_circular = findViewById<CircularProgressBar>(R.id.progress_circular)*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedometer)
        /*  loadData()
          resetSteps()
  sensorManager = getSystemService(Context.SENSOR_SERVICE)as SensorManager
      }

      override fun onResume() {
          super.onResume()
          running = true
          val stepSensor: Sensor? = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
          if (stepSensor == null) {
              Toast.makeText(this, "No sensor detected on this device", Toast.LENGTH_SHORT).show()
          }else{
              sensorManager?.registerListener(this,stepSensor,SensorManager.SENSOR_DELAY_UI)
          }
      }
      override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

      }
      override fun onSensorChanged(event: SensorEvent?) {
          if(running) {
              totalSteps = event!!.values[0]
              val currentSteps:Int = totalSteps.toInt() - previousTotalSteps.toInt()
              tv_stepsTaken.text = ("$currentSteps")
              progress_circular.apply {
                  setProgressWithAnimation(currentSteps.toFloat())
              }
              }
          }
      fun resetSteps(){
         tv_stepsTaken.setOnClickListener {
             Toast.makeText(this, "Long tap to reset steps", Toast.LENGTH_SHORT).show()
         }
          tv_stepsTaken.setOnLongClickListener {
              previousTotalSteps = totalSteps
              tv_stepsTaken.text = 0.toString()
              saveData()
              true
          }

      }
      private fun saveData(){
          val  sharedPreferences : SharedPreferences = getSharedPreferences("myPrefs",Context.MODE_PRIVATE)
          val editor = sharedPreferences.edit()
          editor.putFloat("key1",previousTotalSteps)
          editor.apply()

      }
      private fun loadData(){
          val  sharedPreferences : SharedPreferences = getSharedPreferences("myPrefs",Context.MODE_PRIVATE)
          val savedNumber:Float = sharedPreferences.getFloat("key1",0f)
          Log.d("Pedomerter","SavedNumber")
          previousTotalSteps = savedNumber*/
    }


}
