package shared

// Componente concreto: Espresso
class Espresso : Beverage {
    private var size: Size = Size.GRANDE

    override fun getDescription(): String {
        return "Espresso"
    }

    override fun cost(): Double {
        return when (size) {
            Size.TALL -> 1.99
            Size.GRANDE -> 2.19
            Size.VENTI -> 2.39
        }
    }

    override fun getSize(): Size = size
    override fun setSize(size: Size) { this.size = size }
}