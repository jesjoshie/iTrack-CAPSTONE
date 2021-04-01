package com.example.itrack.DateIterator

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate


class DateProgression(override val start: LocalDate, override val endInclusive: LocalDate, val stepDays: Long=1):
        Iterable<LocalDate>, ClosedRange<LocalDate>{
    override fun iterator(): kotlin.collections.Iterator<LocalDate> =
            DateIterator(start, endInclusive, stepDays)
    infix fun step(days: Long)= DateProgression(start, endInclusive,days)


}
