package com.manamaru.manmaruyoyaku.domain

import com.linecorp.bot.model.message.TextMessage
import com.manamaru.manmaruyoyaku.constants.Constants

class LineTextMessage {
    private val text: String
    private val emojis: List<Emoji>

    constructor(text: String, isColoring: Boolean) {
        var replaceText = text
        val chars = text.toCharArray()
        val emojis = chars.mapIndexed {index,char ->
            replaceText = replaceText.replace(char,'$',false)
            Emoji(char, index,isColoring)
        }
        this.emojis = emojis
        this.text = replaceText
    }

    fun build():TextMessage = TextMessage.builder()
            .apply {
                this.text(text)
                this.emojis(emojis.map { it.build() })
            }.build()
}

class Emoji {
    val index: Int
    val productId: String
    val emojiId: String

    constructor(char: Char, index: Int, isColoring: Boolean){
        this.index = index
        if (isColoring) {
            this.productId = Constants.COLOR_PRODUCT_ID
        } else {
            this.productId = Constants.MONOCHROME_PRODUCT_ID
        }
        this.emojiId = convertToEmojiId(char)
    }

    private fun convertToEmojiId(char: Char):String = Constants.getEmojiID(char)

    fun build(): TextMessage.Emoji = TextMessage.Emoji.builder()
            .apply {
                this.index(index)
                this.productId(productId)
                this.emojiId(emojiId)
            }.build()
}
