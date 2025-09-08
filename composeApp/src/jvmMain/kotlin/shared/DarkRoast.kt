package shared

// Componente concreto: Dark Roast
class DarkRoast : Beverage {
    private var size: Size = Size.GRANDE

    override fun getDescription(): String {
        return "Dark Roast Coffee"
    }

    override fun cost(): Double {
        return when (size) {
            Size.TALL -> 0.99
            Size.GRANDE -> 1.19
            Size.VENTI -> 1.39
        }
    }

    override fun getSize(): Size = size
    override fun setSize(size: Size) { this.size = size }
}