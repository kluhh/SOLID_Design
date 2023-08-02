package com.example.Learning.design_patterns
import kotlin.properties.Delegates



class WeatherStation {
    // Declare a temperature property with an observable delegate that notifies observers when changed
    var temperature by Delegates.observable(0.0) { _, old, new ->//onChange parameter is skipped
        println("Temperature changed from $old to $new") // Print the change in temperature
        observers.forEach { it.update(new) } // Notify all observers
    }

    // List to hold the observers after instantiation
    private val observers = mutableListOf<Observer>()

    // Method to add an observer
    fun addObserver(observerAdded: Observer) {
        println("Observer added.") // Print a message when an observer is added
        observers.add(observerAdded)
    }

    // Method to remove an observer
    fun removeObserver(observerRemoved: Observer) {
        println("Observer removed.") // Print a message when an observer is removed
        observers.remove(observerRemoved)
    }
}

// Observer interface to be implemented by all concrete observers
interface Observer {
    fun update(temperature: Double) // Method called when the subject's state changes
}

class TemperatureDisplay : Observer {
    // Implementation of the update method for this concrete observer
    override fun update(temperature: Double) {
        println("TemperatureDisplay: Temperature updated to $temperature") // Print the updated temperature
    }
}

fun main() {
    val weatherStation = WeatherStation() // Creating the subject(Observable)
    val display = TemperatureDisplay() // Creating the observer

    weatherStation.addObserver(display) // Registering the observer
    weatherStation.temperature = 25.0 // Changing the state, will notify observer
    weatherStation.temperature = 30.0 // Changing the state again, will notify observer
}

