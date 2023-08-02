package com.example.Learning.solid

/*
States that a software module (e.g., a class, function, etc.) should be open for extension but closed for modification.
This means that you should be able to add new functionality without altering the existing code.
 */

// A base class representing a car, open for extension
open class Car4(val model: String) {
    open fun description() = "This is a $model."
}

// An extended class for an electric car
class ElectricCar(model: String, val batteryCapacity: Int) : Car4(model) {
    override fun description() = "This is a $model with battery capacity $batteryCapacity kWh."
}

// A function that operates on the base class without needing to change
fun printCarDescription(car: Car4) {
    println(car.description())
}

// Extension function to print car description
fun Car4.printDescription() {
    println(this.description())
}






fun main() {
    val standardCar = Car4("Model S")
    val electricCar = ElectricCar("Tesla Model X", 100)


    printCarDescription(standardCar) // Output: This is a Model S.
    printCarDescription(electricCar) // Output: This is a Tesla Model X with battery capacity 100 kWh.

    //kotlin feature
    standardCar.printDescription()
    electricCar.printDescription()




}
