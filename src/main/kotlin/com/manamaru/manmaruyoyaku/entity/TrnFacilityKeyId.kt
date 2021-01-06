package com.manamaru.manmaruyoyaku.entity

import java.io.Serializable
import java.util.*
import javax.persistence.Embeddable

@Embeddable
data class TrnFacilityKeyId(
        var facilityId: Int = 0,
        var scheduleDate: Date = Date(),
        var scheduleStartTime: String = "",
        var scheduleEndTime: String = ""
):Serializable