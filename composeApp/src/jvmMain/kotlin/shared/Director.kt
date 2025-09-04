package shared

// Director - opcional pero útil para procesos de construcción complejos
class ComputerDirector {

    fun constructGamingComputer(builder: GamingComputerBuilder): Computer {
        return builder.highEndGamingSetup()
    }

    fun constructOfficeComputer(builder: OfficeComputerBuilder): Computer {
        return builder.standardOfficeSetup()
    }

    fun constructBudgetComputer(builder: OfficeComputerBuilder): Computer {
        return builder.budgetOfficeSetup()
    }

    fun constructDeveloperComputer(builder: OfficeComputerBuilder): Computer {
        return builder.developerSetup()
    }
}