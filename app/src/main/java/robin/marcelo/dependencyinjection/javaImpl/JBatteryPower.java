package robin.marcelo.dependencyinjection.javaImpl;

import android.util.Log;

public class JBatteryPower extends JPowerSource {
    double batteryPercentage;

    public JBatteryPower(double batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    private void discharge(double usedPercentage) {
        try{
            if(batteryPercentage - usedPercentage < 0) {
                throw new Exception("Cannot use more than battery percentage. Current battery percentage is $batteryPercentage");
            } else {
                batteryPercentage -= usedPercentage;
                isProvidingPower = true;
            }
            checkBatteryLife();

        } catch (Exception e) {
            Log.e("Dependency",e.getMessage());
            throw new IllegalStateException();
        }
    }

    private void checkBatteryLife() {
        isProvidingPower = batteryPercentage != 0.0;
    }

    @Override
    void providePower() {
        checkBatteryLife();
        discharge(5.0);
    }

    @Override
    void stopProvidingPower() {
        isProvidingPower = false;
    }
}
