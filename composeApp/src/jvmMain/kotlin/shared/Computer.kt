package shared

// Producto final que vamos a construir
class Computer private constructor(
    val processor: String,
    val ramGB: Int,
    val storageGB: Int,
    val graphicsCard: String?,
    val hasSSD: Boolean,
    val operatingSystem: String,
    val price: Double
){
    // Builder como inner class (enfoque común en Kotlin)
    class Builder {
        private var processor: String = "Intel i5"
        private var ramGB: Int = 8
        private var storageGB: Int = 256
        private var graphicsCard: String? = null
        private var hasSSD: Boolean = true
        private var operatingSystem: String = "Windows 11"
        private var price: Double = 0.0

        fun setProcessor(processor: String) = apply { this.processor = processor }
        fun setRamGB(ramGB: Int) = apply { this.ramGB = ramGB }
        fun setStorageGB(storageGB: Int) = apply { this.storageGB = storageGB }
        fun setGraphicsCard(graphicsCard: String?) = apply { this.graphicsCard = graphicsCard }
        fun setHasSSD(hasSSD: Boolean) = apply { this.hasSSD = hasSSD }
        fun setOperatingSystem(os: String) = apply { this.operatingSystem = os }
        fun setPrice(price: Double) = apply { this.price = price }

        fun build(): Computer {
            // Validaciones antes de construir
            require(ramGB > 0) { "RAM must be positive" }
            require(storageGB > 0) { "Storage must be positive" }
            require(price >= 0) { "Price cannot be negative" }

            return Computer(processor, ramGB, storageGB, graphicsCard, hasSSD, operatingSystem, price)
        }
    }

    fun getSpecifications(): String {
        return """
        🖥️ Especificaciones de la Computadora:
        • Procesador: $processor
        • RAM: ${ramGB}GB
        • Almacenamiento: ${storageGB}GB ${if (hasSSD) "SSD" else "HDD"}
        • Tarjeta Gráfica: ${'$'}{graphicsCard ?: "Integrada"}
        • Sistema Operativo: $operatingSystem
        • Precio: $${price}
        """.trimIndent()
    }

    companion object {
        fun builder() = Builder()
    }
}