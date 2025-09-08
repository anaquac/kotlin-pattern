package shared

import shared.Receivers.Stereo

// Concrete command: Apagar stereo
class StereoOffCommand(private val stereo: Stereo) : Command {

    override fun execute() {
        stereo.off()
    }

    override fun undo() {
        stereo.on()
        stereo.setCD()
        stereo.setVolume(11)
    }

    override fun toString(): String {
        return "Stereo Off"
    }
}