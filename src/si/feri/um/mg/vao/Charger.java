package src.si.feri.um.mg.vao;

public class Charger {
    private String name;
    private int id;
    private Provider provider;

    public Charger(String name, int id, Provider provider) {
        this.name = name;
        this.id = id;
        this.provider = provider;
    }
    public String getName() { return name; }
    public int getId() { return id; }
    public Provider getProvider() { return provider; }

    public void setId(int id) { this.id = id; }
    public void setProvider(Provider provider) { this.provider = provider; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Charger {name=" + name + ", id=" + id + ", provider=" + provider.coreToString() + "}";
    }

    public String onlyChargerToString() {
        return "Charger {name=" + name + ", id=" + id + "}";
    }
}
