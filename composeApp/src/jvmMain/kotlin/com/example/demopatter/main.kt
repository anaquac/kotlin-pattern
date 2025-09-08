package com.example.demopatter
import androidx.compose.ui.window.application
import shared.Beverage
import shared.Caramel
import shared.DarkRoast
import shared.Decaf
import shared.Espresso
import shared.Milk
import shared.Mocha
import shared.Size
import shared.Soy
import shared.Whip


fun main() = application {
    // Demo 1: Bebidas simples
    demoBeveragesSimples()

    println("\n" + "=".repeat(50))

    // Demo 2: Decoradores básicos
    demoDecoradoresBasicos()

    println("\n" + "=".repeat(50))

    // Demo 3: Combinaciones complejas
    demoCombinacionesComplejas()

    println("\n" + "=".repeat(50))

    // Demo 4: Diferentes tamaños
    demoDiferentesTamanos()

}


fun demoDiferentesTamanos() {
    println("📏 Diferentes Tamaños:")

    // Mismo condimento, diferentes tamaños
    val espressoTall = Espresso().apply { setSize(Size.TALL) }
    val espressoGrande = Espresso().apply { setSize(Size.GRANDE) }
    val espressoVenti = Espresso().apply { setSize(Size.VENTI) }

    val mochaTall = Mocha(espressoTall)
    val mochaGrande = Mocha(espressoGrande)
    val mochaVenti = Mocha(espressoVenti)

    println("=== Mocha en diferentes tamaños ===")
    printBeverage(mochaTall)
    printBeverage(mochaGrande)
    printBeverage(mochaVenti)

    // Combo complejo con tamaño personalizado
    val comboPersonalizado = Whip(Mocha(Soy(DarkRoast().apply { setSize(Size.VENTI) })))
    println("\n=== Combo Personalizado Venti ===")
    printBeverage(comboPersonalizado)
}

fun demoCombinacionesComplejas() {
    println("🌈 Combinaciones Complejas:")

    // Dark Roast con doble mocha y crema
    val darkRoastDobleMochaCrema = Whip(Mocha(Mocha(DarkRoast())))
    printBeverage(darkRoastDobleMochaCrema)

    // Espresso con todos los condimentos
    val espressoPremium = Caramel(Whip(Soy(Milk(Mocha(Espresso())))))
    printBeverage(espressoPremium)
}

fun demoDecoradoresBasicos() {
    println("🎨 Decoradores Básicos:")

    // Espresso con leche
    val espressoConLeche = Milk(Espresso())
    printBeverage(espressoConLeche)

    // Dark Roast con mocha
    val darkRoastConMocha = Mocha(DarkRoast())
    printBeverage(darkRoastConMocha)

    // Decaf con soja
    val decafConSoja = Soy(Decaf())
    printBeverage(decafConSoja)
}
fun demoBeveragesSimples() {
    println("☕ Bebidas Simples:")

    val espresso = Espresso()
    val darkRoast = DarkRoast()
    val decaf = Decaf()

    printBeverage(espresso)
    printBeverage(darkRoast)
    printBeverage(decaf)
}


fun printBeverage(beverage: Beverage) {
    println("${beverage.getDescription()} - $${"%.2f".format(beverage.cost())} (${beverage.getSize()})")
}