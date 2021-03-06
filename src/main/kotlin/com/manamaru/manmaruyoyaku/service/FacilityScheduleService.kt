package com.manamaru.manmaruyoyaku.service

import com.manamaru.manmaruyoyaku.domain.FacilitySchedule
import com.manamaru.manmaruyoyaku.entity.TrnFacilityKeyId
import com.manamaru.manmaruyoyaku.entity.TrnFacilitySchedule
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

    fun saveAll(facilityScheduleList: List<FacilitySchedule>) {
        try {
            trnFacilityScheduleRepository.truncateTrnFacilitySchedule()
            val trnFacilitySchedule = facilityScheduleList
                    .map { it ->
                        TrnFacilitySchedule(
                                TrnFacilityKeyId(
                                        it.facilityId,
                                        it.scheduleDate!!,
                                        it.scheduleStartTime,
                                        it.scheduleEndTime),
                                it.scheduleIsAvailable)
                    }
            trnFacilityScheduleRepository.saveAll(trnFacilitySchedule)
        } catch (e: Exception) {
            throw e
        }

    }
}