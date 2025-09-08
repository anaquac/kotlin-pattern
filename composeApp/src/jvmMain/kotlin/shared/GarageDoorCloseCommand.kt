package shared

import shared.Receivers.GarageDoor

// Concrete command: Cerrar puerta de garaje
class GarageDoorCloseCommand(private val garageDoor: GarageDoor) : Command {

    override fun execute() {
        garageDoor.down()
        garageDoor.lightOff()
    }

    override fun undo() {
        garageDoor.up()
        garageDoor.lightOn()
    }

    override fun toString(): String {
        return "Garage Door Close"
    }
}