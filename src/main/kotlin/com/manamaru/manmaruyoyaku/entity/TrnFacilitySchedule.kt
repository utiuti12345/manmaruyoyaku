package com.manamaru.manmaruyoyaku.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "trn_facility_schedule")
data class TrnFacilitySchedule(
        @EmbeddedId var trnFacilityKeyId: TrnFacilityKeyId = TrnFacilityKeyId(),
        @Column(name="schedule_is_available",nullable = false) var scheduleIsAvailable: Boolean = false) {
}