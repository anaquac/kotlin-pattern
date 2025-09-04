package shared

class ElectricCar : Vehicle {
    override fun startEngine() {
        println("Electric car started: ⚡ Silent power! ⚡")
    }

    override fun stopEngine() {
        println("Electric car stopped")
    }

    override fun getInfo(): String {
        return "Electric Car: 4 wheels, 5 seats, zero emissions"
    }
}