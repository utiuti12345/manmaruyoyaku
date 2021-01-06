package com.manamaru.manmaruyoyaku.service

import com.manamaru.manmaruyoyaku.domain.FacilitySchedule
import com.manamaru.manmaruyoyaku.repository.TrnFacilityScheduleRepository
import org.springframework.stereotype.Service

@Service
class FacilityScheduleService(private val trnFacilityScheduleRepository: TrnFacilityScheduleRepository) {
    fun findAll(): List<FacilitySchedule> {
        val trnFacilityScheduleList = trnFacilityScheduleRepository.findAll()
        return trnFacilityScheduleList
                .map { it ->
                    FacilitySchedule(
                            it.trnFacilityKeyId.facilityId,
                            it.trnFacilityKeyId.scheduleDate,
                            it.trnFacilityKeyId.scheduleStartTime,
                            it.trnFacilityKeyId.scheduleEndTime,
                            it.scheduleIsAvailable)
                }.toList()
    }

    fun findAllById(ids: List<Int>): List<FacilitySchedule> = trnFacilityScheduleRepository.findAllById(ids)
            .map { it ->
                FacilitySchedule(
                        it.trnFacilityKeyId.facilityId,
                        it.trnFacilityKeyId.scheduleDate,
                        it.trnFacilityKeyId.scheduleStartTime,
                        it.trnFacilityKeyId.scheduleEndTime,
                        it.scheduleIsAvailable)
            }
}