package shared

// Decorador concreto: Crema Batida
class Whip(beverage: Beverage) : CondimentDecorator(beverage) {

    override fun getDescription(): String {
        return "${beverage.getDescription()}, Whip"
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