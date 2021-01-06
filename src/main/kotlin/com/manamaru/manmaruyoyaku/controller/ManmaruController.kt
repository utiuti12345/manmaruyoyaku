package com.manamaru.manmaruyoyaku.controller

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.message.Message
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import com.manamaru.manmaruyoyaku.service.FacilityScheduleService
import com.manamaru.manmaruyoyaku.service.FacilityService

@LineMessageHandler
class ManmaruController(private val facilityService: FacilityService, private val facilityScheduleService: FacilityScheduleService) {

    @EventMapping
    fun handleTextMessageEvent(event: MessageEvent<TextMessageContent>): List<Message> {
        println("event: $event")
        val text = event.getMessage().getText()
//        val regex = Regex("[1-9]")
//        if(regex.containsMatchIn(text)){
//            return TextMessage("入力が正しくありません。")
//        }

        val facilityList = facilityService.findAll()
        val facilityScheduleList = facilityScheduleService.findAll()

        return facilityList.map { it ->
            val id = it.facilityId
            val facilitySchedule = facilityScheduleList.filter { it -> it.facilityId == id }
            val schedules = facilitySchedule.map { it -> it.formatDatetimeText() }.toList()
            TextMessage(it.facilityName + "\n" + it.facilityAreaName + "\n" + schedules.joinToString(separator = "\n"))
        }.toList()
    }

    @EventMapping
    fun handleDefaultMessageEvent(event: Event) {
        println("event: $event")
    }
}