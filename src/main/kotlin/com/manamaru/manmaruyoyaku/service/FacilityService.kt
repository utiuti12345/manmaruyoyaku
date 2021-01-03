package com.manamaru.manmaruyoyaku.service

import com.manamaru.manmaruyoyaku.entity.MstFacility
import com.manamaru.manmaruyoyaku.repository.MstFacilityRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class FacilityService(private val mstFacilityRepository: MstFacilityRepository){
    fun findAll():List<MstFacility> = mstFacilityRepository.findAll()
    fun findById(id:Int): Optional<MstFacility> = mstFacilityRepository.findById(id)
}