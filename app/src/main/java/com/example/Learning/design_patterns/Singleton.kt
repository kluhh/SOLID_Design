
/*The Singleton pattern is a design pattern that restricts the
 instantiation of a class to a single instance and provides a
 global point of access to that instance. It ensures that there's
 only one instance of the class in the system, and it provides a
 way to access that instance.

Use Case:
Control access
Single point of control
Global
*/

// Singleton class using 'object'
object CarFactorySingleton {

    // Property of the Singleton
    var numberOfCarsProduced: Int = 0
        private set

    // Method of the Singleton
    fun produceCar(model: String): String {
        numberOfCarsProduced++
        return "Producing car model: $model. Total cars produced: $numberOfCarsProduced"
    }
}

fun main() {
    // Access the Singleton's method and property
    println(CarFactorySingleton.produceCar("Model X"))
    println(CarFactorySingleton.produceCar("Model Y"))

    // Output:
    // Producing car model: Model X. Total cars produced: 1
    // Producing car model: Model Y. Total cars produced: 2
}



/*
The CarFactory object is declared using the object keyword, making it a Singleton.
This ensures that there is only one instance of CarFactory.
Inside the CarFactory, there is a property numberOfCarsProduced that keeps track of the number of cars produced,
and a method produceCar that simulates the production of a car and increments the count.
In the main function, you can see that the CarFactory is accessed directly by its name.
Since it's a Singleton, any changes made to its properties are reflected across all usages.
Using the object keyword is a concise and idiomatic way to create a Singleton in Kotlin,
handling all the intricacies of ensuring a single instance and providing global access to that instance.
 */







