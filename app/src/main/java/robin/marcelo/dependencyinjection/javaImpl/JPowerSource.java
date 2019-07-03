package robin.marcelo.dependencyinjection.javaImpl;

public abstract class JPowerSource {
    protected Boolean isProvidingPower = false;
    public Boolean hasPower() {
        return isProvidingPower;
    }

    abstract void providePower();
    abstract void stopProvidingPower();
}
