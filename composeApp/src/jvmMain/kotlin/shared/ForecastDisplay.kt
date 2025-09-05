package shared

// Observador concreto: Predicción del tiempo
class ForecastDisplay(
    private val weatherData: WeatherData
) : Observer, DisplayElement {
    private var currentPressure: Float = 29.92f
    private var lastPressure: Float = 0.0f

    init {
        weatherData.registerObserver(this)
        println("🔮 Display de Pronóstico inicializado")
    }

    override fun update(temperature: Float, humidity: Float, pressure: Float) {
        lastPressure = currentPressure
        currentPressure = pressure
        display()
    }

    override fun display() {
        val forecast = when {
            currentPressure > lastPressure -> "✅ Mejorando el tiempo"
            currentPressure == lastPressure -> "➡️ Tiempo estable"
            else -> "⛈️  Empeorando el tiempo, posible lluvia"
        }

        println("""
        🔮 PRONÓSTICO
        📏 Presión actual: ${currentPressure} hPa
        📏 Presión anterior: ${lastPressure} hPa
        🎯 Predicción: $forecast
        ========================
        """.trimIndent())
    }

    fun unregister() {
        weatherData.removeObserver(this)
    }
}
