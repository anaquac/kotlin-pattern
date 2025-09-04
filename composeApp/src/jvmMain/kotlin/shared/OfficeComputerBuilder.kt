package shared

// Builder especializado para computadoras de oficina
class OfficeComputerBuilder {
    private val builder = Computer.builder()

    fun standardOfficeSetup(): Computer {
        return builder
            .setProcessor("Intel i5-12400")
            .setRamGB(16)
            .setStorageGB(512)
            .setGraphicsCard(null) // Gráficos integrados
            .setHasSSD(true)
            .setOperatingSystem("Windows 11 Pro")
            .setPrice(800.0)
            .build()
    }

    fun budgetOfficeSetup(): Computer {
        return builder
            .setProcessor("Intel i3-12100")
            .setRamGB(8)
            .setStorageGB(256)
            .setGraphicsCard(null)
            .setHasSSD(true)
            .setOperatingSystem("Windows 11")
            .setPrice(500.0)
            .build()
    }

    fun developerSetup(): Computer {
        return builder
            .setProcessor("AMD Ryzen 7 5700X")
            .setRamGB(32)
            .setStorageGB(1000)
            .setGraphicsCard("NVIDIA RTX 3060")
            .setHasSSD(true)
            .setOperatingSystem("Ubuntu 22.04")
            .setPrice(1800.0)
            .build()
    }
}