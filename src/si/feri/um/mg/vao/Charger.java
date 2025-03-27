package src.si.feri.um.mg.vao;

import src.si.feri.um.mg.chainOfResponsibility.ChargerCompatibleHandler;
import src.si.feri.um.mg.chainOfResponsibility.ChargerHandler;
import src.si.feri.um.mg.chainOfResponsibility.ChargerOccupiedHandler;
import src.si.feri.um.mg.chainOfResponsibility.UserBalanceCheckHandler;
import src.si.feri.um.mg.observers.ChargerObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Charger {
    private String name;
    private int id;
    private Provider provider;
    private boolean isActive;
    private double powerOutput;
    private String region;
    private User currentUser;
    private List<ChargerObserver> observers;
    private String acceptedType;
    private double cost;

    public Charger(String name, int id, Provider provider, double powerOutput, String region, String acceptedType) {
        this.name = name;
        this.id = id;
        this.provider = provider;
        this.isActive = false;
        this.powerOutput = powerOutput;
        this.region = region;
        this.currentUser = null;
        this.observers =  new ArrayList<ChargerObserver>();
        this.acceptedType = acceptedType;
        this.cost = 30.0d;
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public Provider getProvider() { return provider; }

    public void setId(int id) { this.id = id; }
    public void setProvider(Provider provider) { this.provider = provider; }
    public void setName(String name) { this.name = name; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) {
        this.isActive = active;
        if (!active) this.currentUser = null; }
    public double getPowerOutput() { return powerOutput; }
    public void setPowerOutput(double powerOutput) { this.powerOutput = powerOutput; }
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
    public String getAcceptedType() {return acceptedType;}
    public void setAcceptedType(String acceptedType) {this.acceptedType = acceptedType;}
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
    public void setCurrentUser(User currentUser) {this.currentUser = currentUser;}
    public User getCurrentUser() { return currentUser; }

    public void charge(User user) {
        this.currentUser = user;
        this.isActive = true;
        notifyObservers("start");
    }

    public void chargingEnd(String userEmail) {
        if (Objects.equals(this.currentUser.getEmail(), userEmail)) {
            this.isActive = false;
            this.currentUser = null;
            notifyObservers("end");
        }
    }

    public void addObserver(ChargerObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(ChargerObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String action) {
        observers.forEach(observer -> observer.update(this, currentUser.getEmail(), action));
    }

    @Override
    public String toString() {
        return "Charger {name=" + name + ", id=" + id + ", isActive: " + isActive + ", power: " + powerOutput + ", region: " + region + ", provider=" + provider.coreToString() + "}";
    }

    public String onlyChargerToString() {
        return "Charger {name=" + name + ", id=" + id + ", isActive: " + isActive + ", power: " + powerOutput + ", region: " + region + "}";
    }
}
