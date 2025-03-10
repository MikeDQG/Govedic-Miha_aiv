package src.si.feri.um.mg.dao.interfaces;

import src.si.feri.um.mg.vao.Charger;

import java.util.List;
import java.util.Optional;

public interface IChargerDAO {
    void insertCharger(Charger charger);
    Optional<Charger> getChargerById(int id);
    List<Charger> getAllChargers();
    void updateCharger(int id, String name);
    void deleteCharger(int id);

}
