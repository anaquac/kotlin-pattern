package shared.Receivers

// Luz inteligente
class Light (private val location: String = "Living Room") {
    fun on(){
        println("💡 $location light is ON")
    }

    fun off(){
        println("💡 $location light is OFF")
    }

    fun dim(level: Int){
        println("💡 $location light is dimmed to $level #️⃣")
    }
}