package shared


// Observador concreto: Muestra condiciones actuales
class CurrentConditionsDisplay(
    private val weatherData: WeatherData
): Observer, DisplayElement {
    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f

    init {
        weatherData.registerObserver(this)
        println("📊 Display de Condiciones Actuales inicializado")
    }

    override fun update(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        display()
    }

    override fun display() {
        println("""
        📍 CONDICIONES ACTUALES
        🌡️  Temperatura: ${temperature}°C
        💧 Humedad: ${humidity}%
        ========================
        """.trimIndent())
    }

    fun unregister() {
        weatherData.removeObserver(this)
    }
}