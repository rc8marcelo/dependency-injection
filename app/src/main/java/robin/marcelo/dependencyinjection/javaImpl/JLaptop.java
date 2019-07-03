package robin.marcelo.dependencyinjection.javaImpl;

import android.util.Log;

public class JLaptop {
    private JPowerSource powerSource;
    public JLaptop(JPowerSource _powerSource) {
        this.powerSource = _powerSource;
    }

    public void turnOn() {
        powerSource.providePower();
        if(powerSource.hasPower()) {
            Log.i("Dependency", "I'm turned on ;)");
        } else {
            Log.e("Dependency", "No power D: ");
        }
    }

    public void useLaptop() {
        powerSource.providePower();
        Log.i("Dependency", "I'm being used ;)");
    }

    public void turnOff() {
        powerSource.stopProvidingPower();
        Log.i("Dependency", "I'm turned off :c");
    }
}
