package shared

import shared.Receivers.GarageDoor


// Concrete command: Abrir puerta de garaje
class GarageDoorOpenCommand(private val garageDoor: GarageDoor) : Command {

    override fun execute() {
        garageDoor.up()
        garageDoor.lightOn()
    }

    override fun undo() {
        garageDoor.down()
        garageDoor.lightOff()
    }

    override fun toString(): String {
        return "Garage Door Open"
    }
}