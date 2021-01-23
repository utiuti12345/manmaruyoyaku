package com.manamaru.manmaruyoyaku.repository

import com.manamaru.manmaruyoyaku.entity.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Repository
interface MstCalendarRepository : JpaRepository<MstCalendar, Int> {
    @Query(value = "select count(*) from mst_calendar where date = ?1",nativeQuery = true)
    fun findByDate(date: String):Int
}