package shared


class Car : Vehicle {
    override fun startEngine() {
        println("Car engine started: Vroom Vroom!")
    }

    override fun stopEngine() {
        println("Car engine stopped")
    }

    override fun getInfo(): String {
        return "Car: 4 wheels, 5 seats, gasoline engine"
    }
}