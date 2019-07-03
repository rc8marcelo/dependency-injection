package robin.marcelo.dependencyinjection.kotlinImpl

class DirectPower: PowerSource() {
    fun plugCable(){
        isProvidingPower = true
    }

    fun unplugCable() {
        isProvidingPower = false
    }

    override fun providePower() {
        plugCable()
    }

    override fun stopPowerFlow() {
        unplugCable()
    }
}