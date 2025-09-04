package shared

class Logger private constructor() {

    companion object {
        @Volatile
        private var instance: Logger? = null

        fun getInstance(): Logger {
            return instance ?: synchronized(this) {
                instance ?: Logger().also { instance = it }
            }
        }
    }

    fun log(message: String) {
        println("[LOG] ${java.time.LocalDateTime.now()}: $message")
    }

    fun error(message: String) {
        println("[ERROR] ${java.time.LocalDateTime.now()}: $message")
    }

    fun debug(message: String) {
        println("[DEBUG] ${java.time.LocalDateTime.now()}: $message")
    }

    // Prevenir la clonación del singleton
    fun clone(): Nothing {
        throw AssertionError("Cannot clone a singleton object")
    }
}