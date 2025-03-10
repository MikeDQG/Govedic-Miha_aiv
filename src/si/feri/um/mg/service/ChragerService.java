package src.si.feri.um.mg.service;

import src.si.feri.um.mg.dao.ChargerDAO;
import src.si.feri.um.mg.dao.interfaces.IChargerDAO;
import src.si.feri.um.mg.vao.Charger;
import src.si.feri.um.mg.vao.Provider;

import java.util.List;
import java.util.Optional;

public class ChragerService {

    private final IChargerDAO chargerDAO = ChargerDAO.getInstance();

    public Charger createCharger(String name, int id, Provider provider) {
        if (name == null || name.isEmpty() || provider == null) {
            throw new IllegalArgumentException("Name/provider cannot be null or empty");
        }
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be negative");
        }
        Charger charger = new Charger(name, id, provider);
        chargerDAO.insertCharger(charger);
        return charger;
    }

    public Charger getChargerById(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be negative");
        }
        return chargerDAO.getChargerById(id).orElse(null);
    }

    public List<Charger> getAllChargers() {
        return chargerDAO.getAllChargers();
    }

    public boolean updateCharger(int id, String name) {
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be negative");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        Optional<Charger> charger = chargerDAO.getChargerById(id);
        if (charger.isPresent()) {
            chargerDAO.updateCharger(id, name);
        }
        return charger.isPresent();
    }

    public boolean deleteCharger(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be negative");
        }
        Optional<Charger> charger = chargerDAO.getChargerById(id);
        if (charger.isPresent()) {
            chargerDAO.deleteCharger(id);
        }
        return charger.isPresent();
    }
}
