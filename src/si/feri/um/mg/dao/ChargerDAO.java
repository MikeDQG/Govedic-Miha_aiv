package src.si.feri.um.mg.dao;

import src.si.feri.um.mg.dao.interfaces.IChargerDAO;
import src.si.feri.um.mg.vao.Charger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ChargerDAO implements IChargerDAO {

    private static volatile ChargerDAO instance;

    private ChargerDAO() {}

    private final List<Charger> chargers = Collections.synchronizedList(new ArrayList<>());

    public static ChargerDAO getInstance() {
        if (instance == null) {
            synchronized (ChargerDAO.class) {
                if (instance == null) {
                    instance = new ChargerDAO();
                }
            }
        }
        return instance;
    }

    @Override
    public void insertCharger(Charger charger) {
        synchronized (chargers) {
            chargers.add(charger);
        }
    }

    @Override
    public Optional<Charger> getChargerById(int id) {
        synchronized (chargers) {
            return chargers.stream().filter(charger -> charger.getId() == id).findFirst();
        }
    }

    @Override
    public List<Charger> getAllChargers() {
        synchronized (chargers) {
            return chargers;
        }
    }

    @Override
    public void updateCharger(int id, String name) {
        synchronized (chargers) {
            getChargerById(id).ifPresent(charger -> charger.setName(name));
        }
    }

    @Override
    public void deleteCharger(int id) {
        synchronized (chargers) {
            chargers.removeIf(charger -> charger.getId() == id);
        }
    }
}
