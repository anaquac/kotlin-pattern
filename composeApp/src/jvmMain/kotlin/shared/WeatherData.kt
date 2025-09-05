package shared


// Interfaz para el sujeto
interface Subject {
    fun registerObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()
}

// Sujeto concreto que mantiene el estado y notifica a observadores
class WeatherData : Subject {
    private val observers = mutableListOf<Observer>()
    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f
    private var pressure: Float = 0.0f

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
        println("➕ Observador registrado: ${observer::class.simpleName}")
    }

    override fun removeObserver(observer: Observer) {
        if (observers.remove(observer)) {
            println("➖ Observador removido: ${observer::class.simpleName}")
        }
    }

    override fun notifyObservers() {
        println("🔔 Notificando a ${observers.size} observadores...")
        observers.forEach { observer ->
            observer.update(temperature, humidity, pressure)
        }
    }

    // Método para actualizar las mediciones
    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        println("\n🌤️  Nuevas mediciones recibidas:")
        println("   Temperatura: ${temperature}°C")
        println("   Humedad: ${humidity}%")
        println("   Presión: ${pressure} hPa")
        measurementsChanged()
    }

    private fun measurementsChanged() {
        // Podrías añadir aquí:
        // - Validaciones
        // - Logging
        // - Transformaciones de datos
        // - Condiciones para notificar o no
        notifyObservers()
    }

    // Métodos para obtener el estado actual
    fun getTemperature(): Float = temperature
    fun getHumidity(): Float = humidity
    fun getPressure(): Float = pressure

    fun getObserverCount(): Int = observers.size
}