package com.example.Learning.design_patterns

/*
Car is the complex object that we want to create.

The nested Builder class inside the Car class helps in building the Car object step by step.

The apply function is used to enable a fluent interface, allowing the methods to be chained together.

The build method constructs the final Car object with the accumulated parameters.

In the main function, we're using the Builder to create a Car object by specifying its properties
 step by step and then building the final object.

This pattern ensures that the Car object is constructed properly, even when there
 are many parameters, some of which may have defaults. It also makes the client code more readable
 and maintainable, particularly when dealing with objects that require many parameters to be set during construction.
*/

class Car2(
    val make: String, // Car make
    val model: String, // Car model
    val year: Int, // Manufacturing year
    val color: String, // Car color
    val transmissionType: String // Transmission type
) {
    class Builder {
        // Required and optional attributes
        private var make: String = ""
        private var model: String = ""
        private var year: Int = 0
        private var color: String = "White" // Default color
        private var transmissionType: String = "Automatic" // Default transmission type

        // Builder methods for setting attributes
        fun make(make: String) = apply { this.make = make }
        fun model(model: String) = apply { this.model = model }
        fun year(year: Int) = apply { this.year = year }
        fun color(color: String) = apply { this.color = color }
        fun transmissionType(transmissionType: String) = apply { this.transmissionType = transmissionType }


//Can be written with a single apply block but will have to set the value of all attributes

//        fun setAttributes(
//            make: String,
//            model: String,
//            year: Int,
//            color: String = "White",
//            transmissionType: String = "Automatic"
//        ) = apply {
//            this.make = make
//            this.model = model
//            this.year = year
//            this.color = color
//            this.transmissionType = transmissionType
//        }



        // Build method to construct the final Car object
        fun build() = Car2(make, model, year, color, transmissionType)
    }

    // Custom toString method for pretty printing
    override fun toString(): String {
        return "Car(make='$make', model='$model', year=$year, color='$color', transmissionType='$transmissionType')"
    }
}

fun main() {
    // Building a Car object using the Builder pattern
    val car = Car2.Builder()
        .make("Toyota") // Set make
        .model("Camry") // Set model
        .year(2023) // Set year
        .color("Blue") // Set color
        .transmissionType("Automatic") // Set transmission type
        .build() // Construct the final Car object

    println(car) // Print the constructed Car object
}


