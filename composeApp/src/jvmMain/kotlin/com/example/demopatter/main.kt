package com.example.demopatter
import androidx.compose.ui.window.application
import shared.GarageDoorCloseCommand
import shared.GarageDoorOpenCommand
import shared.LightOffCommand
import shared.LightOnCommand
import shared.MacroCommand
import shared.Receivers.GarageDoor
import shared.Receivers.Stereo
import shared.RemoteControl
import shared.StereoOffCommand
import shared.StereoOnCommand

import shared.Receivers.Light


fun main() = application {
    println("🎯 Demostración del Patrón Command")
    println("=".repeat(50))

    // Crear receivers (dispositivos)
    val livingRoomLight = Light("Living Room")
    val kitchenLight = Light("Kitchen")
    val garageDoor = GarageDoor()
    val stereo = Stereo()

    // Crear commands
    val livingRoomLightOn = LightOnCommand(livingRoomLight)
    val livingRoomLightOff = LightOffCommand(livingRoomLight)
    val kitchenLightOn = LightOnCommand(kitchenLight)
    val kitchenLightOff = LightOffCommand(kitchenLight)
    val garageDoorOpen = GarageDoorOpenCommand(garageDoor)
    val garageDoorClose = GarageDoorCloseCommand(garageDoor)
    val stereoOn = StereoOnCommand(stereo)
    val stereoOff = StereoOffCommand(stereo)

    // Crear macro command (party mode)
    val partyOn = MacroCommand(listOf(livingRoomLightOn, stereoOn, garageDoorOpen))
    val partyOff = MacroCommand(listOf(livingRoomLightOff, stereoOff, garageDoorClose))

    // Configurar control remoto
    val remote = RemoteControl()
    remote.setCommand(0, livingRoomLightOn, livingRoomLightOff)
    remote.setCommand(1, kitchenLightOn, kitchenLightOff)
    remote.setCommand(2, stereoOn, stereoOff)
    remote.setCommand(3, garageDoorOpen, garageDoorClose)
    remote.setCommand(4, partyOn, partyOff)

    // Demo 1: Control remoto básico
    println(remote.toString())

    println("\n1️⃣  PRUEBAS BÁSICAS:")
    remote.onButtonWasPushed(0)  // Luz living on
    remote.offButtonWasPushed(0) // Luz living off
    remote.undoButtonWasPushed() // Undo: luz living on

    println("\n2️⃣  PRUEBAS MÚLTIPLES:")
    remote.onButtonWasPushed(1)  // Luz cocina on
    remote.onButtonWasPushed(2)  // Stereo on
    remote.onButtonWasPushed(3)  // Garage door open
    remote.undoButtonWasPushed() // Undo: garage door close

    println("\n3️⃣  MODO FIESTA:")
    remote.onButtonWasPushed(4)  // Party mode ON
    println("\n--- Después de la fiesta ---")
    remote.offButtonWasPushed(4) // Party mode OFF
    remote.undoButtonWasPushed() // Undo: party mode ON

    println("\n4️⃣  PRUEBA DE ERROR:")
    try {
        remote.onButtonWasPushed(10) // Slot inválido
    } catch (e: IllegalArgumentException) {
        println("❌ Error: ${e.message}")
    }

    println("\n" + "=".repeat(50))
    println("🏁 Demostración completada")
}
