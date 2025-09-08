package shared

// Clase abstracta para todos los decoradores de condimentos
abstract class CondimentDecorator(protected val beverage: Beverage) : Beverage {
    override fun getSize(): Size = beverage.getSize()
    override fun setSize(size: Size) { beverage.setSize(size) }

    // Las clases concretas deben implementar getDescription() y cost()
}