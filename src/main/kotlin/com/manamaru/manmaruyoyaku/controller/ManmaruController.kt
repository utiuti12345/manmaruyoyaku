package com.manamaru.manmaruyoyaku.controller

import com.manamaru.manmaruyoyaku.domain.Facility
import com.manamaru.manmaruyoyaku.domain.FacilitySchedule
import com.manamaru.manmaruyoyaku.service.FacilityScheduleService
import com.manamaru.manmaruyoyaku.service.FacilityService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ManmaruController(private val facilityService: FacilityService, private val facilityScheduleService: FacilityScheduleService) {

    @GetMapping("facilities")
    fun getFacilities():List<Facility>{
        return facilityService.findAll()
    }

    @GetMapping("schedule")
    fun getSchedule():List<FacilitySchedule>{
        return facilityScheduleService.findAll()
    }

    @PostMapping("/schedule")
    fun createUserById(@RequestBody facilityScheduleList: List<FacilitySchedule>) {
        return facilityScheduleService.saveAll(facilityScheduleList)
    }
}