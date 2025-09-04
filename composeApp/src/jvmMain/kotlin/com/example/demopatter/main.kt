package com.example.demopatter
import androidx.compose.ui.window.application
import shared.CreditCardPayment

import shared.Product
import shared.ShoppingCart
import shared.PayPalPayment
import shared.CryptoPayment


fun main() = application {
    println("🎯 Demostración del Patrón Strategy")
    println("=".repeat(50))

    // Crear algunos productos
    val products = listOf(
        Product("1", "iPhone 15", 999.99, "Electrónicos"),
        Product("2", "Nike Air Max", 129.99, "Calzado"),
        Product("3", "Libro Kotlin Programming", 49.99, "Libros"),
        Product("4", "Auriculares Sony", 199.99, "Audio")
    )

    // Demo 1: Estrategia de tarjeta de crédito
    demoCreditCardStrategy(products)

    println("\n" + "=".repeat(50))

    // Demo 2: Cambio de estrategia en tiempo de ejecución
    demoRuntimeStrategyChange(products)

    println("\n" + "=".repeat(50))

    // Demo 3: Estrategia de criptomonedas
    demoCryptoStrategy(products)
}

fun demoCreditCardStrategy(products: List<Product>) {
    println("💳 Demo: Estrategia Tarjeta de Crédito")

    val cart = ShoppingCart()
    val creditCardStrategy = CreditCardPayment(
        cardNumber = "4111111111111111",
        cardHolder = "Juan Pérez",
        cvv = "123",
        expirationDate = "12/25"
    )

    // Añadir productos
    cart.addProduct(products[0])
    cart.addProduct(products[1])

    // Establecer estrategia y checkout
    cart.setPaymentStrategy(creditCardStrategy)
    cart.showCart()

    val success = cart.checkout()
    println("Resultado del checkout: ${if (success) "✅ Éxito" else "❌ Fallo"}")
}

fun demoRuntimeStrategyChange(products: List<Product>) {
    println("🔄 Demo: Cambio de Estrategia en Tiempo de Ejecución")

    val cart = ShoppingCart()

    // Añadir productos
    cart.addProduct(products[2])
    cart.addProduct(products[3])

    // Primera estrategia: PayPal
    val paypalStrategy = PayPalPayment(
        email = "usuario@example.com",
        password = "password123"
    )

    cart.setPaymentStrategy(paypalStrategy)
    cart.showCart()

    println("--- Cambiando estrategia durante el proceso ---")

    // Cambiar a cripto en tiempo de ejecución
    val cryptoStrategy = CryptoPayment(
        walletAddress = "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa",
        cryptocurrency = "Bitcoin"
    )

    cart.setPaymentStrategy(cryptoStrategy)
    val success = cart.checkout()
    println("Resultado del checkout: ${if (success) "✅ Éxito" else "❌ Fallo"}")
}

fun demoCryptoStrategy(products: List<Product>) {
    println("🌐 Demo: Estrategia Criptomonedas")

    val cart = ShoppingCart()
    val cryptoStrategy = CryptoPayment(
        walletAddress = "0x742d35Cc6634C0532925a3b844Bc454e4438f44e",
        cryptocurrency = "Ethereum"
    )

    // Añadir todos los productos
    products.forEach { cart.addProduct(it) }

    cart.setPaymentStrategy(cryptoStrategy)
    cart.showCart()

    val success = cart.checkout()
    println("Resultado del checkout: ${if (success) "✅ Éxito" else "❌ Fallo"}")

    // Limpiar carrito
    cart.clearCart()
}