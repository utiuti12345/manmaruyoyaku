package com.manamaru.manmaruyoyaku.controller

import com.linecorp.bot.model.event.MessageEvent
import com.linecorp.bot.model.event.message.TextMessageContent
import com.linecorp.bot.model.message.Message
import com.linecorp.bot.model.message.TextMessage
import com.linecorp.bot.spring.boot.annotation.EventMapping
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler
import com.manamaru.manmaruyoyaku.domain.Facility
import com.manamaru.manmaruyoyaku.domain.FacilitySchedule
import com.manamaru.manmaruyoyaku.service.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@LineMessageHandler
class ManmaruController(private val facilityService: FacilityService,
                        private val facilityScheduleService: FacilityScheduleService,
                        private val calendarService: CalendarService,
                        private val execCrawlerDateService: ExecCrawlerDateService,
                        private val lineService: LineService) {

    @GetMapping("facilities")
    fun getFacilities(): List<Facility> {
        return facilityService.findAll()
    }

    @GetMapping("schedule")
    fun getSchedule(): List<FacilitySchedule> {
        return facilityScheduleService.findAll()
    }

    @PostMapping("schedules")
    @ResponseStatus(HttpStatus.CREATED)
    fun createSchedules(@RequestBody facilityScheduleList: List<FacilitySchedule>): ResponseEntity<String> {
        facilityScheduleService.saveAll(facilityScheduleList)
        val date = Date()
        execCrawlerDateService.save(1,date)
        lineService.broadcast(listOf("にっていがこうしんされました"))
        return ResponseEntity.ok("success!!!")
    }

    @EventMapping
    fun handleTextMessageEvent(event: MessageEvent<TextMessageContent>): List<Message> {
        println("event: $event")
        val text = event.getMessage().getText()
        val regex = Regex("([1-9]|1[0-2])月")

        val facilityList = facilityService.findAll()
        val facilityScheduleList = facilityScheduleService.findAll()
        val facilityScheduleComparator: Comparator<FacilitySchedule> =
                compareBy<FacilitySchedule> {
                    it.formatDatetimeSort()
                }
        if(regex.containsMatchIn(text)){
            return facilityList.map { it ->
                val id = it.facilityId
                val facilitySchedule = facilityScheduleList
                        .filter {
                                it.facilityId == id &&
                                it.scheduleIsAvailable &&
                                it.getMonthToString() == text
                        }
                        .sortedWith(facilityScheduleComparator)
                val schedules = facilitySchedule.map {
                    val isHoliday = calendarService.findCountByDate(it.formatDate()) == 1
                    it.formatDatetimeText(isHoliday)
                }.toList()
                TextMessage(it.facilityName + "\n" + it.facilityAreaName + "\n" + schedules.joinToString(separator = "\n"))
            }.toList()
        }

        return facilityList.map { it ->
            val id = it.facilityId

            val facilitySchedule = facilityScheduleList
                    .filter { it.facilityId == id && it.scheduleIsAvailable }
                    .sortedWith(facilityScheduleComparator)
            val schedules = facilitySchedule.map {
                val isHoliday = calendarService.findCountByDate(it.formatDate()) == 1
                it.formatDatetimeText(isHoliday)
            }.toList()
            TextMessage(it.facilityName + "\n" + it.facilityAreaName + "\n" + schedules.joinToString(separator = "\n"))
        }.toList()
    }
}
