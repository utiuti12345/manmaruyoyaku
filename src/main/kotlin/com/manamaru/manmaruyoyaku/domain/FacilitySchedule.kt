package com.manamaru.manmaruyoyaku.domain

import java.text.SimpleDateFormat
import java.util.*

class FacilitySchedule{
    val facilityId: Int
    val scheduleDate: Date
    val scheduleStartTime: String
    val scheduleEndTime: String
    val scheduleIsAvailable:Boolean
    constructor(_facilityId:Int,_scheduleDate:Date,_scheduleStartTime:String,_scheduleEndTime:String,_scheduleIsAvailable:Boolean){
        this.facilityId = _facilityId
        this.scheduleDate = _scheduleDate
        this.scheduleStartTime = _scheduleStartTime
        this.scheduleEndTime = _scheduleEndTime
        this.scheduleIsAvailable = _scheduleIsAvailable
    }

    fun formatDatetimeText(): String {
        val df = SimpleDateFormat("yyyy/MM/dd")
        val formatDate = df.format(scheduleDate)
        return "$formatDate $scheduleStartTime〜$scheduleEndTime"
    }
}