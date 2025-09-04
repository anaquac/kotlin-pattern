package com.example.demopatter
import androidx.compose.ui.window.application

import shared.Computer
import shared.ComputerDirector
import shared.GamingComputerBuilder
import shared.OfficeComputerBuilder

fun main() = application {
    println("🎯 Demostración del Patrón Builder")
    println("=".repeat(50))

    // Demo 1: Builder básico con método de encadenamiento
    demoBasicBuilder()

    println("\n" + "=".repeat(50))

    // Demo 2: Builders especializados
    demoSpecializedBuilders()

    println("\n" + "=".repeat(50))

    // Demo 3: Usando Director
    demoWithDirector()

    println("\n" + "=".repeat(50))

    // Demo 4: Construcción personalizada
    demoCustomBuild()
}

fun demoBasicBuilder() {
    println("🔧 Builder Básico:")

    // Construcción paso a paso con encadenamiento
    val computer = Computer.builder()
        .setProcessor("AMD Ryzen 5 5600X")
        .setRamGB(16)
        .setStorageGB(1000)
        .setGraphicsCard("NVIDIA GTX 1660")
        .setHasSSD(true)
        .setOperatingSystem("Windows 11")
        .setPrice(900.0)
        .build()

    println(computer.getSpecifications())
}

fun demoSpecializedBuilders() {
    println("🎮 Builders Especializados:")

    val gamingBuilder = GamingComputerBuilder()
    val officeBuilder = OfficeComputerBuilder()

    val gamingPC = gamingBuilder.midRangeGamingSetup()
    val officePC = officeBuilder.standardOfficeSetup()
    val devPC = officeBuilder.developerSetup()

    println("=== Computadora Gaming ===")
    println(gamingPC.getSpecifications())

    println("\n=== Computadora Oficina ===")
    println(officePC.getSpecifications())

    println("\n=== Computadora Desarrollador ===")
    println(devPC.getSpecifications())
}

fun demoWithDirector() {
    println("🎭 Usando Director:")

    val director = ComputerDirector()
    val gamingBuilder = GamingComputerBuilder()
    val officeBuilder = OfficeComputerBuilder()

    val highEndGamingPC = director.constructGamingComputer(gamingBuilder)
    val budgetOfficePC = director.constructBudgetComputer(officeBuilder)

    println("=== High-End Gaming (via Director) ===")
    println(highEndGamingPC.getSpecifications())

    println("\n=== Budget Office (via Director) ===")
    println(budgetOfficePC.getSpecifications())
}

fun demoCustomBuild() {
    println("🛠️ Construcción Personalizada:")

    val gamingBuilder = GamingComputerBuilder()

    // Computadora personalizada con parámetros opcionales
    val customPC = gamingBuilder.customGamingSetup(
        processor = "Intel i7-13700K",
        ramGB = 64,
        storageGB = 4000,
        graphicsCard = "NVIDIA RTX 4090",
        price = 3500.0
    )

    println(customPC.getSpecifications())
}