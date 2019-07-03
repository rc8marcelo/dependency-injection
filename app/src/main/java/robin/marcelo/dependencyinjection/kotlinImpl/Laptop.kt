package robin.marcelo.dependencyinjection.kotlinImpl

import android.util.Log

class Laptop {
    lateinit var powerSource: PowerSource
    fun turnOn() {
        powerSource.providePower()
        if(powerSource.hasPower()) {
            Log.i("Dependency", "I'm turned on ;)")
        } else {
            Log.e("Dependency", "No power D: ")
        }
    }

    fun useLaptop() {
        powerSource.providePower()
        Log.i("Dependency", "I'm being used ;)")
    }

    fun turnOff() {
        powerSource.stopPowerFlow()
        Log.i("Dependency", "I'm turned off :c")
    }
}