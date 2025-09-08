package shared

// Interfaz para crear todos los comandos
interface Command {
    fun execute()
    fun undo()
}