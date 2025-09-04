package shared

// Clase de dominio: Producto
data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val category: String
) {
    override fun toString(): String {
        return "$name - $${price} (${category})"
    }
}