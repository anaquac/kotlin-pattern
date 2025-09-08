package shared.Receivers

// Sistema de audio del living room
class Stereo(private val location: String = "Living Room") {
    fun on(){
        println("🔊 $location stereo is ON")
    }

    fun off(){
        println("🔊 $location stereo is OFF")
    }

    fun setCD(){
        println("🔊 $location stereo set to CD mode")
    }

    fun setDVD(){
        println("🔊 $location stereo set to DVD mode")
    }

    fun setRadio(){
        println("🔊 $location stereo set to Radio mode")
    }

    fun setVolume(volume: Int){
        println("🔊 $location stereo set set volume to $volume #️⃣")
    }
}