package shared

import shared.Receivers.Light

// Concrete command: Encender luz
class LightOnCommand(private val light: Light) : Command {

    override fun execute() {
        light.on()
    }

    override fun undo() {
        light.off()
    }

    override fun toString(): String {
        return "Light On"
    }
}