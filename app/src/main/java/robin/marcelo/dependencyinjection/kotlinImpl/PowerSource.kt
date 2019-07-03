package robin.marcelo.dependencyinjection.kotlinImpl

abstract class PowerSource {
     var isProvidingPower: Boolean = false
    fun hasPower(): Boolean {
        return isProvidingPower
    }

    abstract fun providePower()
    abstract fun stopPowerFlow()
}