package shared

import shared.Receivers.Stereo

// Concrete command: Encender stereo con CD
class StereoOnCommand(private val stereo: Stereo) : Command {

    override fun execute() {
        stereo.on()
        stereo.setCD()
        stereo.setVolume(11)
    }

    override fun undo() {
        stereo.off()
    }

    override fun toString(): String {
        return "Stereo On with CD"
    }
}