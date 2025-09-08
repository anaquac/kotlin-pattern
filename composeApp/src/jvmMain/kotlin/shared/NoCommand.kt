package shared

// Null object para slots vacíos
class NoCommand : Command {

    override fun execute() {
        // No hace nada
    }

    override fun undo() {
        // No hace nada
    }

    override fun toString(): String {
        return "No Command"
    }
}