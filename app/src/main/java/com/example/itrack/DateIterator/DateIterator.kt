package com.example.itrack.DateIterator

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

class DateIterator(val startDate: LocalDate,
                   val endDateInclusive: LocalDate,
                   val stepDays: Long) : Iterator<LocalDate> {
    private var currentDate = startDate

    override fun hasNext() = currentDate <= endDateInclusive



    @RequiresApi(Build.VERSION_CODES.O)
    override fun next(): LocalDate {
        val next = currentDate
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            currentDate = currentDate.plusDays(stepDays)
        }
        return  next
    }
}
