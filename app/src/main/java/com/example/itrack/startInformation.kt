package com.example.itrack

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.DialogFragment
import com.example.itrack.models.last_period_info
import ru.cleverpumpkin.calendar.CalendarDate
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*
import kotlin.collections.ArrayList

class startInformation : AppCompatActivity() {
    lateinit var lastperiod_info: last_period_info
    val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.US)

    var age = 0
    var lperiod_Year = 0
    var lperiod_Month = 0
    var lperiod_Day = 0
    var avgcycle = 0
    var purpose = " "
    var lPeriodDate = " "
    var cycleSelected = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_information)


        // spinner dropDown elements
        val cycle_spinner = findViewById<Spinner>(R.id.avgCycle)

        val cycleRanges = ArrayList<String>()
        cycleRanges.add("None")
        val ranges_number = 21..45 step 1
        for (i in ranges_number) {
            cycleRanges.add(i.toString())
        }

        cycle_spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cycleRanges)
        cycle_spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(view: AdapterView<*>?, p1: View?, position: Int, id: Long) {
                if (cycleRanges[position]== "None"){
                    avgcycle = 0
                }
                else{
                    avgcycle = cycleRanges[position].toInt()
                }

            }

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                TODO("Not yet implemented")
            }
        }
    }
        // show datePickeDialog for the last period input
        fun lastPeriod(view: View) {
            var lastperiodText = findViewById<TextView>(R.id.lastperiod)
            val cal = Calendar.getInstance()
            val datePick = DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
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
            }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
            datePick.show()
        }

        fun proceed(view: View) {
            val proceedIntent = Intent(this, EnterUser::class.java)
            proceedIntent.putExtra("lperiod_Year", lperiod_Year)
            proceedIntent.putExtra("lperiod_month", lperiod_Month)
            proceedIntent.putExtra("lperiod_Day", lperiod_Day)
            proceedIntent.putExtra("lPeriodDate", lPeriodDate)
            proceedIntent.putExtra("avgcycle", avgcycle)
            proceedIntent.putExtra("age", age)
            startActivity(proceedIntent)

        }
}

