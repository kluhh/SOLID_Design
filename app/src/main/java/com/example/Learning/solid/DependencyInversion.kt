package com.example.Learning.solid

/*
The Dependency Inversion Principle (DIP) is the last of the SOLID principles,
and it's all about decoupling high-level modules from low-level modules by introducing abstractions.
This principle consists of two key guidelines:

High-level modules should not depend on low-level modules. Both should depend on abstractions.
Abstractions should not depend on details. Details should depend on abstractions.
 */

//without dependency inversion
class GasEngine {
    fun run() = "Gas engine running"
}

class Car10 {
    private val engine = GasEngine()

    fun drive() {
        println(engine.run()) // Depends directly on GasEngine
    }
}
/*
Code above makes it hard to run a different type of engine
 */


//with dependency inversion

interface Engine20 {
    fun run(): String//no details
}

class GasEngine20 : Engine20 {
    override fun run() = "Gas engine running"
}

class ElectricEngine20 : Engine20 {
    override fun run() = "Electric engine running"
}



class Car20(private val engine: Engine20) {
    fun drive() {
        println(engine.run()) // Depends on abstraction
    }
}

fun main() {
    val gasEngine = GasEngine20()
    val electricEngine = ElectricEngine20()

    val gasCar = Car20(gasEngine)
    gasCar.drive() // Output: Gas engine running

    val electricCar = Car20(electricEngine)
    electricCar.drive() // Output: Electric engine running
}

/*
By depending on an abstraction (Engine interface) instead of a concrete class,
the Car class is now decoupled from specific engine implementations.
This makes the code more flexible and easier to maintain. You can add or modify engine types without affecting the Car class.


 */

