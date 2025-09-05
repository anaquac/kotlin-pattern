package shared

// Observador concreto: Display de terceros (ejemplo adicional)
class ThirdPartyDisplay(
    private val weatherData: WeatherData,
    private val displayName: String = "Terceros"
) : Observer, DisplayElement {

    private var heatIndex: Float = 0.0f

    init {
        weatherData.registerObserver(this)
        println("🌡️  Display de $displayName inicializado")
    }

    override fun update(temperature: Float, humidity: Float, pressure: Float) {
        heatIndex = computeHeatIndex(temperature, humidity)
        display()
    }

    override fun display() {
        println("""
        🔥 $displayName - Índice de Calor
        🌡️  Sensación térmica: ${"%.1f".format(heatIndex)}°C
        ========================
        """.trimIndent())
    }

    private fun computeHeatIndex(t: Float, rh: Float): Float {
        // Fórmula simplificada del índice de calor
        return 16.923f + 1.85212f * t + 0.01215f * rh - 0.0034f * t * rh
    }

    fun unregister() {
        weatherData.removeObserver(this)
    }
}