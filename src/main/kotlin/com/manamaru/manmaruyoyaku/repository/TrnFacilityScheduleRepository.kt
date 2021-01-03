package com.manamaru.manmaruyoyaku.repository

import com.manamaru.manmaruyoyaku.entity.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TrnFacilityScheduleRepository : JpaRepository<TrnFacilitySchedule, Int> {
}