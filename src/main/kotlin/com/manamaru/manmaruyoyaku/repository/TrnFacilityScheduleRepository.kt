package com.manamaru.manmaruyoyaku.repository

import com.manamaru.manmaruyoyaku.entity.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface TrnFacilityScheduleRepository : JpaRepository<TrnFacilitySchedule, Int> {
    @Transactional
    @Modifying
    @Query(value = "truncate table trn_facility_schedule",nativeQuery = true)
    fun truncateTrnFacilitySchedule()
}