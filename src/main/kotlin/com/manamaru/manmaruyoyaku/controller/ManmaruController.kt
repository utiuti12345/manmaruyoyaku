package com.manamaru.manmaruyoyaku.controller

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import com.manamaru.manmaruyoyaku.service.FacilityScheduleService
import com.manamaru.manmaruyoyaku.service.FacilityService
import java.text.SimpleDateFormat
import java.util.*

@LineMessageHandler
class ManmaruController(private val facilityService: FacilityService, private val facilityScheduleService: FacilityScheduleService) {

    @EventMapping
    fun handleTextMessageEvent(event: MessageEvent<TextMessageContent>): TextMessage {
        println("event: $event")
        val text = event.getMessage().getText()
//        val regex = Regex("[1-9]")
//        if(regex.containsMatchIn(text)){
//            return TextMessage("入力が正しくありません。")
//        }

        val facilityList = facilityService.findAll()
        val facilitySchedule = facilityScheduleService.findAll()
        val month = event.getMessage().getText()
        val year = Date().year
        facilityList.map {
            val id = it.facilityId
            val facilitySchedule = facilitySchedule.filter { it.facilityId == id }
            val schedules = facilitySchedule.map {
                val df = SimpleDateFormat("yyyy/MM/dd")
                val temp = it.scheduleDate
                val format = df.format(temp)
                it.scheduleDate.date.toString() + " " + it.scheduleStartTime + "〜" + it.scheduleEndTime }.toList()
            val text = it.facilityDisplayName + "\n" + schedules.joinToString(separator="\n")
            print(text)
        }

        return TextMessage(event.getMessage().getText())
    }

    @EventMapping
    fun handleDefaultMessageEvent(event: Event) {
        println("event: $event")
    }
}