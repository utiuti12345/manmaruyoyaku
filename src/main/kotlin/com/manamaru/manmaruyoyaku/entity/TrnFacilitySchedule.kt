package com.manamaru.manmaruyoyaku.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "trn_facility_schedule")
data class TrnFacilitySchedule(
        @Id @GeneratedValue var facilityId: Int = 0,
        @Column(name="schedule_date", nullable = false) var scheduleDate: Date = Date(),
        @Column(name="schedule_start_time",nullable = false) var scheduleStartTime: String = "",
        @Column(name="schedule_end_time",nullable = false) var scheduleEndTime: String = "",
        @Column(name="schedule_is_available",nullable = false) var scheduleIsAvailable: Boolean = false) {
}