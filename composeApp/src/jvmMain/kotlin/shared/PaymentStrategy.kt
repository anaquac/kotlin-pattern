package shared

interface PaymentStrategy{
    fun pay(ammount: Double): Boolean;
    fun getPaymentDetails(): String;
    val paymentMethodName: String;
}