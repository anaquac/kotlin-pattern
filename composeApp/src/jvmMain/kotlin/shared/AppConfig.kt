package shared

object AppConfig {
    private const val DEFAULT_TIMEOUT = 3000

    var apiUrl: String = "https://api.ejemplo.com"
    var timeout: Int = DEFAULT_TIMEOUT
    var isDebugMode: Boolean = false

    fun resetToDefaults() {
        apiUrl = "https://api.ejemplo.com"
        timeout = DEFAULT_TIMEOUT
        isDebugMode = false
    }

    fun printConfig() {
        println("""
            🔧 Configuración de la Aplicación:
            API URL: $apiUrl
            Timeout: $timeout ms
            Debug Mode: $isDebugMode
        """.trimIndent())
    }
}