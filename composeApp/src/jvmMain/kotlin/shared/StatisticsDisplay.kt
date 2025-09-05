package shared

// Observador concreto: Muestra estadísticas
class StatisticsDisplay(private val weatherData: WeatherData
) : Observer, DisplayElement {
    private val temperatures = mutableListOf<Float>()
    private val humidities = mutableListOf<Float>()
    private val pressures = mutableListOf<Float>()

    init {
        weatherData.registerObserver(this)
        println("📈 Display de Estadísticas inicializado")
    }

    override fun update(temperature: Float, humidity: Float, pressure: Float) {
        temperatures.add(temperature)
        humidities.add(humidity)
        pressures.add(pressure)
        display()
    }

    override fun display() {
        if (temperatures.isEmpty()) return

        val avgTemp = temperatures.average()
        val maxTemp = temperatures.maxOrNull() ?: 0.0f
        val minTemp = temperatures.minOrNull() ?: 0.0f

        val avgHumidity = humidities.average()
        val avgPressure = pressures.average()

        println("""
        📊 ESTADÍSTICAS
        🌡️  Temp: Avg=${"%.1f".format(avgTemp)}°C, Max=$maxTemp°C, Min=$minTemp°C
        💧 Humedad Promedio: ${"%.1f".format(avgHumidity)}%
        📏 Presión Promedio: ${"%.1f".format(avgPressure)} hPa
        📈 Muestras: ${temperatures.size}
        ========================
        """.trimIndent())
    }

    fun unregister() {
        weatherData.removeObserver(this)
    }

    fun clearStatistics() {
        temperatures.clear()
        humidities.clear()
        pressures.clear()
        println("🧹 Estadísticas limpiadas")
    }
}