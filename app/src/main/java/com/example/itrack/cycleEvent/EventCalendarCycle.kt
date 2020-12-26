package com.example.itrack.cycleEvent


import ru.cleverpumpkin.calendar.CalendarDate
import ru.cleverpumpkin.calendar.CalendarView


// color indicators


class EventCalendarCycle(
        override val date: CalendarDate,
        override val color: Int,
        val eventName: String

) : CalendarView.DateIndicator