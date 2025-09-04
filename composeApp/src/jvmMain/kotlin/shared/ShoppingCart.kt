package shared


// Contexto: Carrito de compras que usa una estrategia de pago
class ShoppingCart {
    private val items = mutableListOf<Product>()
    private var paymentStrategy: PaymentStrategy? = null

    fun addProduct(product: Product) {
        items.add(product)
        println("➕ Añadido: $product")
    }

    fun removeProduct(productId: String) {
        items.removeIf { it.id == productId }
        println("➖ Eliminado producto: $productId")
    }

    fun setPaymentStrategy(strategy: PaymentStrategy) {
        this.paymentStrategy = strategy
        println("🎯 Estrategia de pago cambiada a: ${strategy.paymentMethodName}")
    }

    fun getTotalAmount(): Double {
        return items.sumOf { it.price }
    }

    fun checkout(): Boolean {
        val total = getTotalAmount()
        if (total <= 0) {
            println("🛒 El carrito está vacío")
            return false
        }

        val strategy = paymentStrategy
        if (strategy == null) {
            println("❌ No se ha seleccionado método de pago")
            return false
        }

        println("\n🧾 INICIANDO CHECKOUT")
        println("=".repeat(40))
        println("Productos en carrito:")
        items.forEachIndexed { index, product ->
            println("${index + 1}. $product")
        }
        println("=".repeat(40))
        println("TOTAL: $${"%.2f".format(total)}")
        println("Método de pago: ${strategy.getPaymentDetails()}")
        println("=".repeat(40))

        return strategy.pay(total)
    }

    fun clearCart() {
        items.clear()
        paymentStrategy = null
        println("🗑️ Carrito limpiado")
    }

    fun showCart() {
        if (items.isEmpty()) {
            println("🛒 Carrito vacío")
            return
        }

        println("\n🛒 Contenido del Carrito:")
        println("=".repeat(30))
        items.forEachIndexed { index, product ->
            println("${index + 1}. $product")
        }
        println("=".repeat(30))
        println("Total: $${"%.2f".format(getTotalAmount())}")
    }
}