package robin.marcelo.dependencyinjection

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.cambridge.dependencyinjection.R
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import robin.marcelo.dependencyinjection.javaImpl.JBatteryPower
import robin.marcelo.dependencyinjection.javaImpl.JLaptop
import robin.marcelo.dependencyinjection.kotlinImpl.BatteryPower
import robin.marcelo.dependencyinjection.kotlinImpl.DirectPower
import robin.marcelo.dependencyinjection.kotlinImpl.Laptop

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callBadCode()
//        callGoodCode()
//        callBetterCode()
    }

    fun callBadCode() {
        val myMacBookPro = Laptop()
        myMacBookPro.powerSource = DirectPower()
        myMacBookPro.turnOn()
        myMacBookPro.useLaptop()
        myMacBookPro.turnOff()

        val myAsusLappy = Laptop()
        myAsusLappy.powerSource = BatteryPower(10.0)
        myAsusLappy.turnOn()
        myAsusLappy.useLaptop()
        myAsusLappy.useLaptop()
        myAsusLappy.turnOff()
    }

    private fun callGoodCode() {
        //Should normally be inside onCreate but is placed here instead for brevity
        val powerSource = JBatteryPower(10.0)
        val myMacBookPro = JLaptop(powerSource)
        myMacBookPro.turnOn()
        myMacBookPro.useLaptop()
        myMacBookPro.useLaptop()
        myMacBookPro.turnOff()
    }

    private fun callBetterCode() {
        val myLenovoLappy = Laptop()
        val powerSource: BatteryPower by inject()
        myLenovoLappy.powerSource = powerSource
        myLenovoLappy.turnOn()
        myLenovoLappy.useLaptop()
        myLenovoLappy.turnOff()
    }
}
