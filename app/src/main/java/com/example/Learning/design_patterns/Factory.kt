
//Factory Method is a pattern that defines an interface for creating an object but
// lets subclasses alter the type of objects that will be created.


// Product Interface - Defines what all cars should have in common
interface Car {
    fun startEngine() // Method to start the car's engine
}

// Concrete Product - Sedan car implementing the Car interface
class Sedan : Car {
    override fun startEngine() {
        println("Sedan engine started!") // Implementation for Sedan engine start
    }
}

// Concrete Product - SUV car implementing the Car interface
class SUV : Car {
    override fun startEngine() {
        println("SUV engine started!") // Implementation for SUV engine start
    }
}

// Creator Abstract Class - Defines the method to create a car
abstract class CarFactory {//we to let concrete factory decide what type of car to create
    abstract fun createCar(): Car // has to be created when factory is created

    fun testCar() {// want every factory to create a car and start engine
        val car = createCar() // Create the car using the abstract factory method
        car.startEngine() // Start the engine of the created car
        println("Car tested!") // Confirm test
    }
}

/*
Can also use an interface instead of an abstract class
however the test car method may be different for subclasses.

// Creator Interface
interface CarFactory {
fun createCar(): Car
fun testCar()
}
*/



// Concrete Creator - Specific factory for creating Sedan cars
class SedanFactory : CarFactory() {
    override fun createCar() = Sedan() // Create and return a Sedan car
}

// Concrete Creator - Specific factory for creating SUV cars
class SUVFactory : CarFactory() {
    override fun createCar() = SUV() // Create and return an SUV car
}

fun main() {
    val sedanFactory = SedanFactory() // Create SedanFactory instance
    sedanFactory.testCar() // test a Sedan car
    // Output: Sedan engine started!
    //         Car tested!

    val suvFactory = SUVFactory() // Create SUVFactory instance
    suvFactory.testCar() // test an SUV car
    // Output: SUV engine started!
    //         Car tested!
}
