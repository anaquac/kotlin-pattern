package shared

// Estrategia concreta: Pago con PayPal
class PayPalPayment(
    private val email: String,
    private val password: String
) : PaymentStrategy {

    override fun pay(amount: Double): Boolean {
        println("📧 Iniciando sesión en PayPal: $email")
        println("🔐 Autenticando usuario...")
        Thread.sleep(800)
        println("💰 Transferiendo $amount a través de PayPal")
        Thread.sleep(600)
        println("✅ Pago con PayPal completado")
        return true
    }

    override fun getPaymentDetails(): String {
        return "PayPal: $email"
    }

    override val paymentMethodName: String = "PayPal"
}