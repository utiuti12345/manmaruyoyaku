package com.manamaru.manmaruyoyaku.service

import com.manamaru.manmaruyoyaku.entity.TrnFacilitySchedule
import com.manamaru.manmaruyoyaku.repository.TrnFacilityScheduleRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class FacilityScheduleService(private val trnFacilityScheduleRepository: TrnFacilityScheduleRepository){
    fun findAll():List<TrnFacilitySchedule> = trnFacilityScheduleRepository.findAll()
    fun findAllById(ids:List<Int>): List<TrnFacilitySchedule> = trnFacilityScheduleRepository.findAllById(ids)
}