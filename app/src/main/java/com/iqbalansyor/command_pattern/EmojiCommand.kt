package com.iqbalansyor.command_pattern

import android.widget.TextView

const val emojiSmile = "😀"
const val emojiThumb = "👍"
const val emojiLook = "👀"
const val emojiFamily = "👨‍👩‍👦"

/// command : 1
interface EmojiCommand {
    fun execute()
    fun undo()
}

/// command: 2
class SmileEmojiCommand(private val textView: TextView): EmojiCommand {
    override fun execute() {
        textView.text = textView.text.toString() + emojiSmile
    }

    override fun undo() {
        textView.text = textView.text.dropLast(2)
    }
}
//
class ThumbEmojiCommand(private val textView: TextView): EmojiCommand {
    override fun execute() {
        textView.text = textView.text.toString() + emojiThumb
    }

    override fun undo() {
        textView.text = textView.text.dropLast(2)
    }
}
//
class LookEmojiCommand(private val textView: TextView): EmojiCommand {
    override fun execute() {
        textView.text = textView.text.toString() + emojiLook
    }

    override fun undo() {
        textView.text = textView.text.dropLast(2)
    }
}
//
class FamilyEmojiCommand(private val textView: TextView): EmojiCommand {
    override fun execute() {
        textView.text = textView.text.toString() + emojiFamily
    }

    override fun undo() {
        textView.text = textView.text.dropLast(8)
    }
}