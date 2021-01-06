package com.manamaru.manmaruyoyaku.service

import com.manamaru.manmaruyoyaku.domain.Facility
import com.manamaru.manmaruyoyaku.entity.MstFacility
import com.manamaru.manmaruyoyaku.repository.MstFacilityRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class FacilityService(private val mstFacilityRepository: MstFacilityRepository) {
    fun findAll(): List<Facility> {
        val mstFacilityList = mstFacilityRepository.findAll()
        return mstFacilityList
                .map { it ->
                    Facility(it.facilityId,
                            it.facilityName,
                            it.facilityAreaName,
                            it.facilityDisplayName)
                }.toList()
    }

    fun findById(id: Int): Optional<Facility> = mstFacilityRepository.findById(id)
            .map { it ->
                Facility(it.facilityId,
                        it.facilityName,
                        it.facilityAreaName,
                        it.facilityDisplayName)
            }
}