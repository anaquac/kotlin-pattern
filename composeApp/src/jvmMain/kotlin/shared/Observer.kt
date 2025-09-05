package shared


// Interfaz para todos los observadores
interface Observer {
    fun update(temperature: Float, humidity: Float, presure: Float)
}

// interfaz para elementos visuales
interface DisplayElement{
    fun display()
}