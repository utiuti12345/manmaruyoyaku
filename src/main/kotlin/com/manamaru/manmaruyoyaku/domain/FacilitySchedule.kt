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
    val emoji:String = "\uDBC0\uDC84"

    var weekName = arrayOf("日", "月", "火",
            "水", "木", "金", "土")

    constructor(facilityId: Int, scheduleDate: Date, scheduleStartTime: String, scheduleEndTime: String, scheduleIsAvailable: Boolean){
        this.facilityId = facilityId
        // 9時間ズレる問題が環境で解決できなかったので、9時間ズラす
        calendar.time = scheduleDate
        calendar.add(Calendar.HOUR_OF_DAY,9)
        this.scheduleDate = calendar.getTime()
        this.scheduleStartTime = scheduleStartTime
        this.scheduleEndTime = scheduleEndTime
        this.scheduleIsAvailable = scheduleIsAvailable
    }

    fun formatDatetimeText(isHoliday:Boolean): String {
        val df = SimpleDateFormat("yyyy/MM/dd")
        val formatDate = df.format(calendar.getTime())
        val dayOfWeek = getDayOfWeek()
        val holidayEmoji = if(isHoliday) emoji else ""
        return "${formatDate}(${dayOfWeek})${scheduleStartTime}〜${scheduleEndTime}${holidayEmoji}"
    }

    fun formatDate():String = SimpleDateFormat("yyyy/MM/dd").format(scheduleDate)

    fun formatDatetimeSort(): Date{
        calendar.time = scheduleDate
        calendar.add(Calendar.HOUR_OF_DAY,scheduleStartTime.replace("時","").let { it.toInt() })
        return calendar.getTime()
    }

    fun getDayOfWeek(): String{
        // 9時間ズレる問題が環境で解決できなかったので、9時間逆にズラす
        calendar.time = scheduleDate
        calendar.add(Calendar.HOUR_OF_DAY,-9)
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        return weekName[dayOfWeek]
    }

    fun getMonthToString(): String{
        calendar.time = scheduleDate
        val month = (calendar.get(Calendar.MONTH)+1).toString()
        return "${month}月";
    }
}