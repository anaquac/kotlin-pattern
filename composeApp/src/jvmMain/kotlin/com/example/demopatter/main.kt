package com.example.demopatter
import androidx.compose.ui.window.application

import shared.Logger
import shared.AppConfig

fun main() = application {
    println("🔍 Demostración del Patrón Singleton")
    println("=".repeat(40))

    // Demo 1: Logger Singleton
    demoLoggerSingleton()

    println("\n" + "=".repeat(40))

    // Demo 2: AppConfig Singleton
    demoAppConfigSingleton()

    println("\n" + "=".repeat(40))

    // Demo 3: Verificación de instancia única
    demoInstanciaUnica()
}

fun demoLoggerSingleton() {
    println("📝 Demo Logger Singleton:")

    // Usar el logger desde diferentes partes
    val logger1 = Logger.getInstance()
    val logger2 = Logger.getInstance()

    logger1.log("Aplicación iniciada")
    logger2.debug("Modo depuración activado")
    logger1.error("Error de conexión detectado")

    // Verificar que es la misma instancia
    println("¿Misma instancia? ${logger1 === logger2}")
}

fun demoAppConfigSingleton() {
    println("⚙️ Demo AppConfig Singleton:")

    // Configurar la aplicación
    AppConfig.apiUrl = "https://api.midominio.com/v1"
    AppConfig.timeout = 5000
    AppConfig.isDebugMode = true

    // Acceder desde diferentes partes del código
    AppConfig.printConfig()

    // Modificar configuración
    println("\n🔄 Modificando configuración...")
    AppConfig.timeout = 2000
    AppConfig.printConfig()
}

fun demoInstanciaUnica() {
    println("🔗 Demo Instancia Única:")

    // Demostrar que siempre obtenemos la misma instancia
    val config1 = AppConfig
    val config2 = AppConfig
    val logger1 = Logger.getInstance()
    val logger2 = Logger.getInstance()

    println("AppConfig misma instancia: ${config1 === config2}")
    println("Logger misma instancia: ${logger1 === logger2}")

    // Mostrar hashcode para demostrar que es el mismo objeto
    println("HashCode AppConfig 1: ${System.identityHashCode(config1)}")
    println("HashCode AppConfig 2: ${System.identityHashCode(config2)}")
    println("HashCode Logger 1: ${System.identityHashCode(logger1)}")
    println("HashCode Logger 2: ${System.identityHashCode(logger2)}")
}