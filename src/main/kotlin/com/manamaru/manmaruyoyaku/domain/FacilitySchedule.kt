package com.manamaru.manmaruyoyaku.domain

import java.text.SimpleDateFormat
import java.util.*

class FacilitySchedule{
    val facilityId: Int
    val scheduleDate: Date?
    val scheduleStartTime: String
    val scheduleEndTime: String
    val scheduleIsAvailable:Boolean
    val calendar: Calendar = Calendar.getInstance()

    var weekName = arrayOf("日", "月", "火",
            "水", "木", "金", "土")

    constructor(facilityId: Int, scheduleDate: Date, scheduleStartTime: String, scheduleEndTime: String, scheduleIsAvailable: Boolean){
        this.facilityId = facilityId
        this.scheduleDate = scheduleDate
        this.scheduleStartTime = scheduleStartTime
        this.scheduleEndTime = scheduleEndTime
        this.scheduleIsAvailable = scheduleIsAvailable
    }

    fun formatDatetimeText(): String {
        val df = SimpleDateFormat("yyyy/MM/dd(E)")
        val formatDate = df.format(scheduleDate)
        val dayOfWeek = getDayOfWeek()
        return "${formatDate} ${scheduleStartTime}〜${scheduleEndTime}"
    }

    fun formatDatetimeSort(): Date{
        calendar.time = scheduleDate
        calendar.add(Calendar.HOUR_OF_DAY,scheduleStartTime.replace("時","").let { it.toInt() })
        return calendar.getTime()
    }

    fun getDayOfWeek(): String{
        calendar.time = Date()
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        return weekName[dayOfWeek]
    }

    fun getMonthToString(): String{
        calendar.time = scheduleDate
        val month = (calendar.get(Calendar.MONTH)+1).toString()
        return "${month}月";
    }
}