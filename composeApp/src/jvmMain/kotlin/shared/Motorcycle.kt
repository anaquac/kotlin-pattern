package shared

class Motorcycle : Vehicle {
    override fun startEngine() {
        println("Motorcycle engine started: Vroom!")
    }

    override fun stopEngine() {
        println("Motorcycle engine stopped")
    }

    override fun getInfo(): String {
        return "Motorcycle: 2 wheels, 2 seats, agile transportation"
    }
}