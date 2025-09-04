package shared

// Builder especializado para computadoras gaming
class GamingComputerBuilder {
    private val builder = Computer.builder()

    fun highEndGamingSetup(): Computer {
        return builder
            .setProcessor("Intel i9-13900K")
            .setRamGB(32)
            .setStorageGB(2000)
            .setGraphicsCard("NVIDIA RTX 4080")
            .setHasSSD(true)
            .setOperatingSystem("Windows 11 Pro")
            .setPrice(2500.0)
            .build()
    }

    fun midRangeGamingSetup(): Computer {
        return builder
            .setProcessor("AMD Ryzen 7 5800X")
            .setRamGB(16)
            .setStorageGB(1000)
            .setGraphicsCard("NVIDIA RTX 3070")
            .setHasSSD(true)
            .setOperatingSystem("Windows 11")
            .setPrice(1500.0)
            .build()
    }

    fun customGamingSetup(
        processor: String = "Intel i7",
        ramGB: Int = 16,
        storageGB: Int = 1000,
        graphicsCard: String = "NVIDIA RTX 3060",
        price: Double = 1200.0
    ): Computer {
        return builder
            .setProcessor(processor)
            .setRamGB(ramGB)
            .setStorageGB(storageGB)
            .setGraphicsCard(graphicsCard)
            .setHasSSD(true)
            .setOperatingSystem("Windows 11")
            .setPrice(price)
            .build()
    }
}