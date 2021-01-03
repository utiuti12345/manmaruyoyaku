package com.manamaru.manmaruyoyaku.controller

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import com.manamaru.manmaruyoyaku.service.FacilityScheduleService
import com.manamaru.manmaruyoyaku.service.FacilityService
import java.util.*

@LineMessageHandler
class ManmaruController(private val facilityService: FacilityService, private val facilityScheduleService: FacilityScheduleService) {

    @EventMapping
    fun handleTextMessageEvent(event: MessageEvent<TextMessageContent>): TextMessage {
        println("event: $event")
        val facilityList = facilityService.findAll()
        val facilitySchedule = facilityScheduleService.findAll()
        val month = event.getMessage().getText()
        val year = Date().year
        facilitySchedule.map {

        }
        return TextMessage(event.getMessage().getText())
    }

    @EventMapping
    fun handleDefaultMessageEvent(event: Event) {
        println("event: $event")
    }
}