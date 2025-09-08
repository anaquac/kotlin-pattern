package shared

import shared.Receivers.Light

// Concrete command: Apagar luz
class LightOffCommand(private val light: Light) : Command {

    override fun execute() {
        light.off()
    }

    override fun undo() {
        light.on()
    }

    override fun toString(): String {
        return "Light Off"
    }
}