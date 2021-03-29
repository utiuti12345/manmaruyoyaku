package com.manamaru.manmaruyoyaku.service

import com.manamaru.manmaruyoyaku.repository.MstCalendarRepository
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*

@Service
class CalendarService(private val mstCalendarRepository: MstCalendarRepository){
    fun findCountByDate(formatDate: String):Int = mstCalendarRepository.findByDate(formatDate)
}