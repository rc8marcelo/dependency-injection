package robin.marcelo.dependencyinjection.kotlinImpl

import android.util.Log
import java.lang.Exception

class BatteryPower(var batteryPercentage: Double = 100.0): PowerSource(){

    fun discharge(usedPercentage: Double) {
        try{

            if(batteryPercentage - usedPercentage < 0) {
                throw Exception("Cannot use more than battery percentage. Current battery percentage is $batteryPercentage")
            } else {
                batteryPercentage -= usedPercentage
                isProvidingPower = true
            }
            checkBatteryLife()

        } catch (e: Exception) {
            Log.e("Dependency",e.message)
            error(e.message!!) //Crashes the app
        }
    }

    private fun checkBatteryLife() {
        isProvidingPower = batteryPercentage != 0.0
    }

    override fun providePower() {
        checkBatteryLife()
        discharge(5.0)
    }

    override fun stopPowerFlow() {
        isProvidingPower = false
    }
}