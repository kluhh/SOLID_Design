package com.example.Learning.solid

/*
The Interface Segregation Principle (ISP) is one of the SOLID principles,
and it states that a client should not be forced to depend on interfaces it does not use.
Essentially, this means that you should divide large, complex interfaces into smaller,
more specific ones, so that the implementing classes only need to be concerned with the methods
that are relevant to them.
*/

interface Vehicle {
    fun drive(): String
    fun fly(): String
    fun sail(): String
}

class Car : Vehicle {
    override fun drive() = "Car is driving."
    override fun fly() = "Car cannot fly." // Irrelevant for Car
    override fun sail() = "Car cannot sail." // Irrelevant for Car
}

class Airplane : Vehicle {
    override fun drive() = "Airplane can taxi on the runway."
    override fun fly() = "Airplane is flying."
    override fun sail() = "Airplane cannot sail." // Irrelevant for Airplane
}

/*
In this example, the Vehicle interface has methods that are not
relevant for all the implementing classes, violating the ISP.
 */




interface Drivable {
    fun drive(): String
}

interface Flyable {
    fun fly(): String
}

interface Sailable {
    fun sail(): String
}

class Car30 : Drivable {
    override fun drive() = "Car is driving."
}

class Airplane30 : Drivable, Flyable {
    override fun drive() = "Airplane can taxi on the runway."
    override fun fly() = "Airplane is flying."
}

class Boat30 : Sailable {
    override fun sail() = "Boat is sailing."
}

fun main() {
    val car = Car()
    println(car.drive()) // Output: Car is driving.

    val airplane = Airplane30()
    println(airplane.drive()) // Output: Airplane can taxi on the runway.
    println(airplane.fly())   // Output: Airplane is flying.

    val boat = Boat30()
    println(boat.sail()) // Output: Boat is sailing.
}







