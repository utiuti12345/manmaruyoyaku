package com.manamaru.manmaruyoyaku.controller

import com.manamaru.manmaruyoyaku.domain.Facility
import com.manamaru.manmaruyoyaku.domain.FacilitySchedule
import com.manamaru.manmaruyoyaku.service.FacilityScheduleService
import com.manamaru.manmaruyoyaku.service.FacilityService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @PostMapping("schedules")
    @ResponseStatus(HttpStatus.CREATED)
    fun createSchedules(@RequestBody facilityScheduleList: List<FacilitySchedule>):ResponseEntity<String> {
        facilityScheduleService.saveAll(facilityScheduleList)
        return ResponseEntity.ok("success")
    }
}