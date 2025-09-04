package shared

// Interface común para todos los vehículos
interface Vehicle {
    fun startEngine()
    fun stopEngine()
    fun getInfo(): String
}

// Tipos de vehículos disponibles
enum class VehicleType {
    CAR,
    MOTORCYCLE,
    TRUCK,
    ELECTRIC_CAR
}