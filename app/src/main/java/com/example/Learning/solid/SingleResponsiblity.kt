package com.example.Learning.solid

/*
A simple way to understand this principle is to think of a class as having only one "job" or "responsibility."
If you find that a class is doing more than one job, that's often an indication that it might be worth splitting
it into two or more classes, each handling a separate concern.

When we say a class should have only one "reason to change," we mean that there should be only one
aspect of the system's functionality that, if altered or extended, would require that class to be changed.

By doing so, if a part of the system changes that impacts that responsibility, you only need to modify that specific class.

 */


// Class responsible for creating a car
class CarFactory3 {
    fun produceCar(model: String) {
        // code to produce a car
    }
}

// Class responsible for logging
class CarLogger {
    fun logProduction(model: String) {
        println("Produced car model: $model")
    }
}

fun main(){
    // Client code
    val factory = CarFactory3()
    val logger = CarLogger()

    val model = "Model X"
    factory.produceCar(model)
    logger.logProduction(model)


}

