💡 Ventajas del Patrón Decorator
✅ Mayor flexibilidad que la herencia: Puedes combinar comportamientos en tiempo de ejecución

✅ Evita la explosión de clases: No necesitas una clase para cada combinación

✅ Principio Open/Closed: Puedes añadir nuevos decoradores sin modificar código existente

✅ Responsabilidad única: Cada decorador se encarga de una funcionalidad específica

🎯 Casos de Uso Comunes
Sistemas de bebidas (como en nuestro ejemplo)

Streams de I/O (BufferedInputStream, DataInputStream, etc.)

Decoradores de UI (bordes, scrollbars, etc.)

Middleware en aplicaciones web

Sistemas de permisos y roles

Ejemplo de Extensión
Para añadir un nuevo condimento:
// Nuevo decorador: Canela
class Cinnamon(beverage: Beverage) : CondimentDecorator(beverage) {

    override fun getDescription(): String {
        return "${beverage.getDescription()}, Cinnamon"
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

// Uso:
val cafeConCanela = Cinnamon(DarkRoast())
printBeverage(cafeConCanela)
