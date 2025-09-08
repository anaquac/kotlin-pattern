package shared

// Decorador concreto: Leche de Soja
class Soy(beverage: Beverage) : CondimentDecorator(beverage) {

    override fun getDescription(): String {
        return "${beverage.getDescription()}, Soy"
    }

    override fun cost(): Double {
        val sizeCost = when (beverage.getSize()) {
            Size.TALL -> 0.15
            Size.GRANDE -> 0.20
            Size.VENTI -> 0.25
        }
        return beverage.cost() + sizeCost
    }
}