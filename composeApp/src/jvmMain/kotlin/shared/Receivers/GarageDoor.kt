package shared.Receivers

// Puerta del garaje
class GarageDoor(private val location: String = "Man Garaje") {

    fun up(){
        println("🚪 $location garage door is UP")
    }

    fun down() {
        println("🚪 $location garage door is DOWN")
    }

    fun stop() {
        println("🚪 $location garage door STOPPED")
    }

    fun lightOn() {
        println("💡 $location garage light is ON")
    }

    fun lightOff() {
        println("💡 $location garage light is OFF")
    }
}