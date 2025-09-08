package shared

// Command que ejecuta múltiples comandos
class MacroCommand(private val commands: List<Command>) : Command {

    override fun execute() {
        println("🎬 Executing Macro Command:")
        commands.forEachIndexed { index, command ->
            print("${index + 1}. ")
            command.execute()
        }
    }

    override fun undo() {
        println("↩️ Undoing Macro Command:")
        commands.reversed().forEachIndexed { index, command ->
            print("${index + 1}. ")
            command.undo()
        }
    }

    override fun toString(): String {
        return "Macro Command: ${commands.joinToString { it.toString() }}"
    }
}