package com.example.itrack

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*


class MoodTracker : AppCompatActivity() {
    val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    var lperiod_Year = 0
    var lperiod_Month = 0
    var lperiod_Day = 0
    var lPeriodDate = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mood_tracker)

    fun lastPeriod(view: View) {


    }}

    fun lastPeriod(view: View) { var lastperiodText = findViewById<TextView>(R.id.datebutton)
        val cal = Calendar.getInstance()
        val datePick = DatePickerDialog(
            this,
            android.R.style.Theme_Holo_Light_Dialog_MinWidth,
            DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                // instance of calendar picker
                val sDate = Calendar.getInstance()
                sDate.set(Calendar.YEAR, mYear)
                sDate.set(Calendar.DAY_OF_MONTH, mDay)
                sDate.set(Calendar.MONTH, mMonth)

                // save instances
                lperiod_Year = mYear
                lperiod_Month = mMonth
                lperiod_Day = mDay

                // set format for calendar to display
                lPeriodDate = sdf.format(sDate.time)

                lastperiodText.text = lPeriodDate
            },
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        )
        datePick.show()}
}
