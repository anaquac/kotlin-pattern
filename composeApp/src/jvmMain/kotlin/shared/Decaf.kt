package shared

// Componente concreto: Decaf
class Decaf : Beverage {
    private var size: Size = Size.GRANDE

    override fun getDescription(): String {
        return "Decaf Coffee"
    }

    override fun cost(): Double {
        return when (size) {
            Size.TALL -> 1.05
            Size.GRANDE -> 1.25
            Size.VENTI -> 1.45
        }
    }

    override fun getSize(): Size = size
    override fun setSize(size: Size) { this.size = size }
}