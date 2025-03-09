package src.si.feri.um.mg.dao;

import src.si.feri.um.mg.dao.interfaces.IChargerDAO;
import src.si.feri.um.mg.vao.Charger;

import java.util.ArrayList;
import java.util.Optional;

public class ChargerDAO implements IChargerDAO {

    private ArrayList<Charger> chargers = new ArrayList<>();

    @Override
    public void insertCharger(Charger charger) {
        chargers.add(charger);
    }

    @Override
    public Optional<Charger> getChargerById(int id) {
        return chargers.stream().filter(charger -> charger.getId() == id).findFirst();
    }

    @Override
    public Iterable<Charger> getAllChargers() {
        return chargers;
    }

    @Override
    public void updateCharger(int id, String name) {
        getChargerById(id).ifPresent(charger -> charger.setName(name));
    }

    @Override
    public void deleteCharger(int id) {
        chargers.removeIf(charger -> charger.getId() == id);
    }
}
