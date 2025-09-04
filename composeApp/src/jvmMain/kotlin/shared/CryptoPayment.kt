package shared

// Estrategia concreta: Pago con criptomonedas
class CryptoPayment(
    private val walletAddress: String,
    private val cryptocurrency: String = "Bitcoin"
) : PaymentStrategy {

    override fun pay(amount: Double): Boolean {
        println("🌐 Conectando a red $cryptocurrency...")
        println("📊 Confirmando transacción en blockchain")
        Thread.sleep(1500)
        println("⛓️ Transacción minada: $amount $cryptocurrency")
        println("✅ Pago con cripto confirmado")
        return true
    }

    override fun getPaymentDetails(): String {
        return "$cryptocurrency: ${walletAddress.take(8)}...${walletAddress.takeLast(8)}"
    }

    override val paymentMethodName: String = "Cryptocurrency"
}