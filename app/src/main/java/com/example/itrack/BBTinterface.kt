package com.example.itrack

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*

class BBTinterface : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_b_tinterface)
        val xValue = findViewById<TextView>(R.id.xValue)
        val yValue = findViewById<TextView>(R.id.yValue)
        val insertBtn = findViewById<Button>(R.id.btnInsert)
        val lineChart = findViewById<LineChart>(R.id.lineChart)

    }


    }


