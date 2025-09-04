package shared

// estrategia para el pago con tarjeta de credito
class CreditCardPayment (
    private val cardNumber: String,
    private val cardHolder: String,
    private val cvv: String,
    private val expirationDate: String
    ): PaymentStrategy{
    override fun pay(amount: Double): Boolean {
        println("💳 Procesando pago con tarjeta de crédito...")
        println("📧 Enviando $amount a banco para autorización")
        // Simulación de procesamiento
        Thread.sleep(1000)
        println("✅ Pago con tarjeta aprobado")
        return true
    }
    override fun getPaymentDetails(): String {
        return "Tarjeta: ****${cardNumber.takeLast(4)} - $cardHolder"
    }

    override val paymentMethodName: String = "Credit Card"
}