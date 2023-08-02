package com.example.Learning.design_patterns


/*The Strategy Design Pattern in this context allows us to define
 various ways to start the car's engine and switch between them flexibly.
 If we want to introduce a new way to start the engine, we can simply create
 a new class that implements StartEngineStrategy, without changing the existing code.
*/

// Strategy Interface defining the method for starting the engine
interface StartEngineStrategy {
    fun startEngine()
}

// Concrete Strategy A: Standard Engine Start
class StandardStart : StartEngineStrategy {
    override fun startEngine() {
        println("Starting the engine with a standard ignition system.")
    }
}

// Concrete Strategy B: Push Button Engine Start
class PushButtonStart : StartEngineStrategy {
    override fun startEngine() {
        println("Starting the engine with a push button.")
    }
}

// Concrete Strategy C: Remote Engine Start
class RemoteStart : StartEngineStrategy {
    override fun startEngine() {
        println("Starting the engine remotely.")
    }
}

// Context class representing the Car, and using a StartEngineStrategy
class Car3(private var startEngineStrategy: StartEngineStrategy) {

    // Method to set the Start Engine Strategy dynamically
    fun setStartEngineStrategy(startEngineStrategy: StartEngineStrategy) {
        this.startEngineStrategy = startEngineStrategy
    }

    // Method to execute the Strategy
    fun startCar() {
        startEngineStrategy.startEngine()
    }
}

fun main() {
    // Create Strategies
    val standardStart = StandardStart()
    val pushButtonStart = PushButtonStart()
    val remoteStart = RemoteStart()

    // Create a Car context and set a starting strategy
    val car = Car3(standardStart)

    // Use the car with standard start
    car.startCar() // Output: Starting the engine with a standard ignition system.

    // Change the starting strategy to push button start
    car.setStartEngineStrategy(pushButtonStart)
    car.startCar() // Output: Starting the engine with a push button.

    // Change the starting strategy to remote start
    car.setStartEngineStrategy(remoteStart)
    car.startCar() // Output: Starting the engine remotely.
}

/*

The StartEngineStrategy interface defines the strategy for starting the engine.
The classes StandardStart, PushButtonStart, and RemoteStart implement
this interface, encapsulating different ways to start the engine.
The Car class represents the context that uses these strategies.
Inside the main function, we create different strategies and apply them to the car.
By changing the starting strategy at runtime, we can achieve different behaviors without
altering the code of the Car class.

 */

