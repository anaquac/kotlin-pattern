package shared

// Decorador concreto: Leche
class Milk(beverage: Beverage) : CondimentDecorator(beverage) {

    override fun getDescription(): String {
        return "${beverage.getDescription()}, Milk"
    }

    override fun cost(): Double {
        val sizeCost = when (beverage.getSize()) {
            Size.TALL -> 0.10
            Size.GRANDE -> 0.15
            Size.VENTI -> 0.20
        }
        return beverage.cost() + sizeCost
    }
}