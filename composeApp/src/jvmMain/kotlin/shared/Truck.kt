package shared

class Truck : Vehicle {
    override fun startEngine() {
        println("Truck engine started: BRRRRUM BRRRRUM!")
    }

    override fun stopEngine() {
        println("Truck engine stopped")
    }

    override fun getInfo(): String {
        return "Truck: 6 wheels, cargo transport, diesel engine"
    }
}