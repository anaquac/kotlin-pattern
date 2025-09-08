package shared

// Invoker: Control remoto
class RemoteControl {
    private val onCommands = Array<Command>(7) { NoCommand() }
    private val offCommands = Array<Command>(7) { NoCommand() }
    private var undoCommand: Command = NoCommand()

    fun setCommand(slot: Int, onCommand: Command, offCommand: Command) {
        require(slot in 0..6) { "Slot must be between 0 and 6" }
        onCommands[slot] = onCommand
        offCommands[slot] = offCommand
    }

    fun onButtonWasPushed(slot: Int) {
        require(slot in 0..6) { "Slot must be between 0 and 6" }
        onCommands[slot].execute()
        undoCommand = onCommands[slot]
    }

    fun offButtonWasPushed(slot: Int) {
        require(slot in 0..6) { "Slot must be between 0 and 6" }
        offCommands[slot].execute()
        undoCommand = offCommands[slot]
    }

    fun undoButtonWasPushed() {
        println("↩️ UNDO: ")
        undoCommand.undo()
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("\n🔶 Remote Control 🔶\n")
        stringBuilder.append("=".repeat(40))

        for (i in onCommands.indices) {
            stringBuilder.append("\n[$i] ${onCommands[i]} \t| ${offCommands[i]}")
        }

        stringBuilder.append("\n[UNDO] $undoCommand")
        stringBuilder.append("\n" + "=".repeat(40))
        return stringBuilder.toString()
    }
}