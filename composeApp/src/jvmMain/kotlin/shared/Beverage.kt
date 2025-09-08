package shared



// Enum para tamaños de bebida
enum class Size {
    TALL, GRANDE, VENTI;

    override fun toString(): String {
        return when (this) {
            TALL -> "Tall"
            GRANDE -> "Grande"
            VENTI -> "Venti"
        }
    }
}


// Interfaz común para todas las bebidas
interface Beverage {
    fun getDescription(): String
    fun cost(): Double
    fun getSize(): Size
    fun setSize(size: Size)

}

