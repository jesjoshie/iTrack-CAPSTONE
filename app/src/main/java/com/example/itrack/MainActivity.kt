package com.example.itrack

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.itrack.bottomNavfragments.graphDataFragment
import com.example.itrack.models.last_period_info
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {
    var btn1Text = " "
    var btn2Text = " "
    var purpose = " "
    var lPeriodDate = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1Text = findViewById<Button>(R.id.trackperiod).hint.toString()
        btn2Text = findViewById<Button>(R.id.pregnancy).hint.toString()
        findViewById<Button>(R.id.trackperiod).setOnClickListener { next(btn1Text) }
        findViewById<Button>(R.id.pregnancy).setOnClickListener { next(btn2Text) }

    }
    //button next
    private fun next(purpose: String){
        val purposeIntent = Intent(applicationContext, startInformation::class.java)
        purposeIntent.putExtra("purpose", purpose)
        startActivity(purposeIntent)
    }

}