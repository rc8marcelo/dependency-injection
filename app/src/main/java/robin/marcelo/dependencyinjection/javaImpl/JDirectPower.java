package robin.marcelo.dependencyinjection.javaImpl;

public class JDirectPower extends JPowerSource {

    private void plugCable(){
        isProvidingPower = true;
    }

    private void unplugCable() {
        isProvidingPower = false;
    }

    @Override
    public void providePower() {
        plugCable();
    }

    @Override
    public void stopProvidingPower() {
        unplugCable();
    }
}
