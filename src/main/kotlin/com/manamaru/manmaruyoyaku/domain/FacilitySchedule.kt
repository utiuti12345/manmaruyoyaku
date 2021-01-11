package com.manamaru.manmaruyoyaku.domain

import java.text.SimpleDateFormat
import java.util.*

class FacilitySchedule{
    val facilityId: Int
    val scheduleDate: Date?
    val scheduleStartTime: String
    val scheduleEndTime: String
    val scheduleIsAvailable:Boolean
    constructor(facilityId:Int,scheduleDate:Date,scheduleStartTime:String,scheduleEndTime:String,scheduleIsAvailable:Boolean){
        this.facilityId = facilityId
        this.scheduleDate = scheduleDate
        this.scheduleStartTime = scheduleStartTime
        this.scheduleEndTime = scheduleEndTime
        this.scheduleIsAvailable = scheduleIsAvailable
    }

    fun formatDatetimeText(): String {
        val df = SimpleDateFormat("yyyy/MM/dd")
        val formatDate = df.format(scheduleDate)
        return "$formatDate $scheduleStartTime〜$scheduleEndTime"
    }
}