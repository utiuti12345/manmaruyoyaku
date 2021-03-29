package com.manamaru.manmaruyoyaku.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "line.bot")
class LineBotConfig {
    var channelToken: String? = null
    var channelSecret: String? = null
}
