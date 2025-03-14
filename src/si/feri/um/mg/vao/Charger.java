package src.si.feri.um.mg.vao;

public class Charger {
    private String name;
    private int id;
    private Provider provider;
    private boolean isActive;
    private double powerOutput;
    private String region;

    public Charger(String name, int id, Provider provider, double powerOutput, String region) {
        this.name = name;
        this.id = id;
        this.provider = provider;
        this.isActive = true;
        this.powerOutput = powerOutput;
        this.region = region;
    }
    public String getName() { return name; }
    public int getId() { return id; }
    public Provider getProvider() { return provider; }

    public void setId(int id) { this.id = id; }
    public void setProvider(Provider provider) { this.provider = provider; }
    public void setName(String name) { this.name = name; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { this.isActive = active; }
    public double getPowerOutput() { return powerOutput; }
    public void setPowerOutput(double powerOutput) { this.powerOutput = powerOutput; }
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    @Override
    public String toString() {
        return "Charger {name=" + name + ", id=" + id + ", isActive: " + isActive + ", power: " + powerOutput + ", region: " + region + ", provider=" + provider.coreToString() + "}";
    }

    public String onlyChargerToString() {
        return "Charger {name=" + name + ", id=" + id + ", isActive: " + isActive + ", power: " + powerOutput + ", region: " + region + "}";
    }
}
