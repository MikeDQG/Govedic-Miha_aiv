package src.si.feri.um.mg.vao;

import java.util.ArrayList;
import java.util.List;

public class Provider {

    private String name;
    private String email;
    private List<Charger> chargers;

    public Provider(String name, String email) {
        this.name = name;
        this.email = email;
        chargers = new ArrayList<Charger>();
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public List<Charger> getChargers() {
        return chargers;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCharger(Charger charger) {
        chargers.add(charger);
    }

    @Override
    public String toString() {
        return "Provider {name=" + name + ", email=" + email + ", chargers=" + chargers.toString() + "}";
    }

    public String coreToString() {
        return "Provdier {name=" + name + ", email=" + email + "}";
    }
}
