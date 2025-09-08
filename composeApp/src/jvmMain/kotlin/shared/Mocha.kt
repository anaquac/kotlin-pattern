package shared


// Decorador concreto: Mocha
class Mocha(beverage: Beverage) : CondimentDecorator(beverage) {

    override fun getDescription(): String {
        return "${beverage.getDescription()}, Mocha"
    }

    override fun cost(): Double {
        val sizeCost = when (beverage.getSize()) {
            Size.TALL -> 0.20
            Size.GRANDE -> 0.25
            Size.VENTI -> 0.30
        }
        return beverage.cost() + sizeCost
    }
}