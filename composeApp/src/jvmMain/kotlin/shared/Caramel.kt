package shared

// Decorador concreto: Caramelo
class Caramel(beverage: Beverage) : CondimentDecorator(beverage) {

    override fun getDescription(): String {
        return "${beverage.getDescription()}, Caramel"
    }

    override fun cost(): Double {
        val sizeCost = when (beverage.getSize()) {
            Size.TALL -> 0.25
            Size.GRANDE -> 0.30
            Size.VENTI -> 0.35
        }
        return beverage.cost() + sizeCost
    }
}