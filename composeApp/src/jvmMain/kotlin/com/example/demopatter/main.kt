package com.example.demopatter
import androidx.compose.ui.window.application

import shared.VehicleFactory
import shared.VehicleType

fun main() = application {
    println("🚗 Vehicle Factory Demo 🏭")
    println("=".repeat(30))

    // Demo básica
    demoBasicFactory()

    println("\n" + "=".repeat(30))

    // Demo avanzada
    demoAdvancedUsage()

    println("\n" + "=".repeat(30))

    // Demo con manejo de errores
    demoWithErrorHandling()

}
fun demoBasicFactory() {
    println("📋 Demo Básica:")

    // Crear diferentes vehículos usando la factory
    val car = VehicleFactory.createVehicle(VehicleType.CAR)
    val motorcycle = VehicleFactory.createVehicle(VehicleType.MOTORCYCLE)
    val truck = VehicleFactory.createVehicle(VehicleType.TRUCK)
    val electricCar = VehicleFactory.createVehicle(VehicleType.ELECTRIC_CAR)

    // Usar los vehículos
    val vehicles = listOf(car, motorcycle, truck, electricCar)

    vehicles.forEach { vehicle ->
        println("\n${vehicle.getInfo()}")
        vehicle.startEngine()
        Thread.sleep(500) // Simular delay
        vehicle.stopEngine()
    }
}

fun demoAdvancedUsage() {
    println("🎯 Demo Avanzada:")

    // Usar la versión con string
    val car = VehicleFactory.createVehicle("car")
    val ev = VehicleFactory.createVehicle("EV")

    println("Vehículo creado por string: ${car.getInfo()}")
    println("Vehículo eléctrico: ${ev.getInfo()}")

    // Mostrar tipos disponibles
    println("\n📊 Tipos disponibles:")
    VehicleFactory.getAvailableTypes().forEach { type ->
        println("- $type")
    }
}

fun demoWithErrorHandling() {
    println("⚠️  Demo con Manejo de Errores:")

    try {
        val unknownVehicle = VehicleFactory.createVehicle("SPACESHIP")
        println(unknownVehicle.getInfo())
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
        println("Usando vehículo por defecto (Car)...")
        val defaultVehicle = VehicleFactory.createVehicle(VehicleType.CAR)
        println(defaultVehicle.getInfo())
    }
}
