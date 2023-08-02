package com.example.Learning.solid

/*
that objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.
Essentially, a subclass should honor the contract established by the superclass.
 */

// Base class for Engine
open class Engine {
    open fun start(): String = "Engine started."
}

// Derived class for Electric Engine, extending the base Engine class
class ElectricEngine : Engine() {
    override fun start(): String = "Electric engine started."
}

// Derived class for Combustion Engine, extending the base Engine class
class CombustionEngine : Engine() {
    override fun start(): String = "Combustion engine started."
}

// Function that accepts an Engine object and uses it to start the engine
fun startEngine(engine: Engine) {
    println(engine.start())
}

fun main() {
    val standardEngine = Engine()
    val electricEngine = ElectricEngine()
    val combustionEngine = CombustionEngine()

    startEngine(standardEngine) // Output: Engine started.
    startEngine(electricEngine) // Output: Electric engine started.
    startEngine(combustionEngine) // Output: Combustion engine started.
}

/*
The Engine class provides a base contract with a method start to start the engine.
The derived classes ElectricEngine and CombustionEngine override the start method to
provide their specific implementations for starting the engine.
The startEngine function accepts an object of type Engine. Thanks to polymorphism,
you can pass in any object that is a subtype of Engine, and the program will work correctly.
In the main function, different engine types are passed to the startEngine function,
demonstrating that the derived classes can be substituted for the base class without any issues.
 */



