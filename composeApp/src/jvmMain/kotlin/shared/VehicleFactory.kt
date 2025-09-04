package shared

// Factory principal usando when expression
object VehicleFactory {

    fun createVehicle(type: VehicleType): Vehicle {
        return when (type) {
            VehicleType.CAR -> Car()
            VehicleType.MOTORCYCLE -> Motorcycle()
            VehicleType.TRUCK -> Truck()
            VehicleType.ELECTRIC_CAR -> ElectricCar()
        }
    }

    // Método sobrecargado para crear vehículo por string
    fun createVehicle(type: String): Vehicle {
        return when (type.uppercase()) {
            "CAR" -> Car()
            "MOTORCYCLE" -> Motorcycle()
            "TRUCK" -> Truck()
            "ELECTRIC_CAR", "EV" -> ElectricCar()
            else -> throw IllegalArgumentException("Unknown vehicle type: $type")
        }
    }

    // Método para obtener todos los tipos disponibles
    fun getAvailableTypes(): List<VehicleType> {
        return VehicleType.values().toList()
    }
}

// Factory alternativa con parámetros (versión avanzada)
class AdvancedVehicleFactory {

    fun createVehicle(
        type: VehicleType,
        color: String = "white",
        maxSpeed: Int = 120
    ): Vehicle {
        val vehicle = when (type) {
            VehicleType.CAR -> Car()
            VehicleType.MOTORCYCLE -> Motorcycle()
            VehicleType.TRUCK -> Truck()
            VehicleType.ELECTRIC_CAR -> ElectricCar()
        }

        // Podríamos usar propiedades adicionales aquí
        println("Created $color vehicle with max speed $maxSpeed km/h")
        return vehicle
    }
}