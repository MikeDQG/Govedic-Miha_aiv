package src.si.feri.um.mg.observers;

import src.si.feri.um.mg.vao.Charger;

public interface ChargerObserver {
    void update(Charger charger, String user, String action);

}
