package com.manamaru.manmaruyoyaku.service

import com.linecorp.bot.client.LineMessagingClient
import com.linecorp.bot.model.Broadcast
import com.linecorp.bot.model.PushMessage
import com.linecorp.bot.model.message.TextMessage
import com.linecorp.bot.model.response.BotApiResponse
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler
import com.manamaru.manmaruyoyaku.config.LineBotConfig
import com.manamaru.manmaruyoyaku.domain.LineTextMessage
import org.springframework.beans.factory.annotation.Autowired

@LineMessageHandler
class LineService{
    @Autowired
    lateinit var lineBotConfig: LineBotConfig
    //private final val lineMessagingClient: LineMessagingClient = LineMessagingClient.builder(lineBotConfig.channelToken).build()
    @Autowired
    private var lineMessagingClient: LineMessagingClient? = null

    /// broadcast
    fun broadcast(messages: List<String>): BotApiResponse? {
        val lineMessages = messages.map {
            LineTextMessage(it, true).build()
        }
        return lineMessagingClient?.broadcast(Broadcast(lineMessages, false))?.get()
                .also {
                    print("broadcast result. $it")
                }
    }

    fun pushMessage(ids: List<String>, messages: List<String>){
        val lineMessages = messages.map { TextMessage(it) }
        ids.map { it -> lineMessagingClient?.pushMessage(PushMessage(it, lineMessages)) }
    }
}
