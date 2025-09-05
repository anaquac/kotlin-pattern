package com.example.demopatter
import androidx.compose.ui.window.application

import shared.WeatherData
import shared.ForecastDisplay
import  shared.StatisticsDisplay
import shared.CurrentConditionsDisplay
import shared.ThirdPartyDisplay

fun main() = application {
    println("🎯 Demostración del Patrón Observer")
    println("=".repeat(50))

    // Crear el sujeto (WeatherData)
    val weatherData = WeatherData()

    // Crear y registrar observadores
    val currentDisplay = CurrentConditionsDisplay(weatherData)
    val statisticsDisplay = StatisticsDisplay(weatherData)
    val forecastDisplay = ForecastDisplay(weatherData)
    val thirdPartyDisplay = ThirdPartyDisplay(weatherData, "App Móvil")

    println("\n👥 Observadores registrados: ${weatherData.getObserverCount()}")
    println("=".repeat(50))

    // Simular cambios en las mediciones
    println("\n1️⃣  PRIMERA ACTUALIZACIÓN:")
    weatherData.setMeasurements(25.0f, 65.0f, 1013.0f)

    Thread.sleep(1000)

    println("\n2️⃣  SEGUNDA ACTUALIZACIÓN:")
    weatherData.setMeasurements(27.5f, 70.0f, 1012.5f)

    Thread.sleep(1000)

    println("\n3️⃣  TERCERA ACTUALIZACIÓN:")
    weatherData.setMeasurements(23.0f, 90.0f, 1010.0f)

    Thread.sleep(1000)

    // Demo: Remover un observador
    println("\n🔴 REMOVIENDO OBSERVADOR:")
    currentDisplay.unregister()
    println("👥 Observadores restantes: ${weatherData.getObserverCount()}")

    println("\n4️⃣  ACTUALIZACIÓN SIN UN OBSERVADOR:")
    weatherData.setMeasurements(21.0f, 85.0f, 1011.0f)

    Thread.sleep(1000)

    // Demo: Limpiar estadísticas
    println("\n🧹 LIMPIANDO ESTADÍSTICAS:")
    statisticsDisplay.clearStatistics()

    println("\n5️⃣  ACTUALIZACIÓN POST-LIMPIEZA:")
    weatherData.setMeasurements(19.0f, 75.0f, 1014.0f)

    println("\n" + "=".repeat(50))
    println("🏁 Demostración completada")
    println("👥 Observadores finales: ${weatherData.getObserverCount()}")
}
