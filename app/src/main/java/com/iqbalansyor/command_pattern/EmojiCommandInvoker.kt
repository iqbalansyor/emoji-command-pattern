package com.iqbalansyor.command_pattern

/// command : 3
object EmojinCommandInvoker {
    private val redos = mutableListOf<EmojiCommand>()
    private val undos = mutableListOf<EmojiCommand>()

    fun command(emojiCommand: EmojiCommand) {
        emojiCommand.execute()
        undos.push(emojiCommand)
        redos.clear()
    }

    fun undo() {
        undos.pop()?.let { command ->
            redos.push(command)
            command.undo()
        }
    }

    fun redo() {
        redos.pop()?.let { command ->
            undos.push(command)
            command.execute()
        }
    }

    fun reset() {
        undos.clear()
        redos.clear()
    }
}
//
fun <T> MutableList<T>.push(item: T) = this.add(0, item)
fun <T> MutableList<T>.pop(): T? = if (this.count() > 0) this.removeAt(0) else null