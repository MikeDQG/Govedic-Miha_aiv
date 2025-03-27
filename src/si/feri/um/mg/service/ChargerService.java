package src.si.feri.um.mg.service;

import src.si.feri.um.mg.InstanceNotFoundException;
import src.si.feri.um.mg.chainOfResponsibility.ChargerCompatibleHandler;
import src.si.feri.um.mg.chainOfResponsibility.ChargerHandler;
import src.si.feri.um.mg.chainOfResponsibility.ChargerOccupiedHandler;
import src.si.feri.um.mg.chainOfResponsibility.UserBalanceCheckHandler;
import src.si.feri.um.mg.dao.ChargerDAO;
import src.si.feri.um.mg.dao.interfaces.IChargerDAO;
import src.si.feri.um.mg.vao.Charger;
import src.si.feri.um.mg.vao.Provider;
import src.si.feri.um.mg.vao.User;

import java.util.List;
import java.util.Optional;

public class ChargerService {

    private final IChargerDAO chargerDAO = ChargerDAO.getInstance();

    public Charger createCharger(String name, int id, Provider provider, double powerOutput, String region, String acceptedType) {
        if (name == null || name.isEmpty() || provider == null || region == null || region.isEmpty() || acceptedType == null || acceptedType.isEmpty()) {
            throw new IllegalArgumentException("Arguments cannot be null or empty");
        }
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be negative");
        }
        Charger charger = new Charger(name, id, provider, powerOutput, region, acceptedType);
        chargerDAO.insertCharger(charger);
        return charger;
    }

    public void charge(Charger charger, User user) {
        ChargerHandler chargerOccupiedHandler = new ChargerOccupiedHandler();
        ChargerHandler userBalanceCheckHandler = new UserBalanceCheckHandler();
        ChargerHandler carTypeCheckHandler = new ChargerCompatibleHandler();

        chargerOccupiedHandler.setNextHandler(userBalanceCheckHandler);
        userBalanceCheckHandler.setNextHandler(carTypeCheckHandler);

        if (chargerOccupiedHandler.handleRequest(charger, user)) {
//            charger.setActive(true);          // je implementirano ze v Charger.java
//            charger.setCurrentUser(user);     // je implementirano ze v Charger.java
            charger.charge(user);
            System.out.println("Charger "+charger.getName()+" started with "+ user.getEmail()+"\n");
        } else {
            System.out.println("Charger not availible for " + user.getEmail()+"\n");
        }
    }

    public Charger getChargerById(int id) throws InstantiationException, IllegalArgumentException {
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be negative");
        }
        Optional<Charger> charger = chargerDAO.getChargerById(id);
        if (charger.isPresent()) {
            return charger.get();
        } else {
            throw new InstanceNotFoundException("Charger with ID " + id + " not found");
        }
    }

    public List<Charger> getAllChargers() {
        return chargerDAO.getAllChargers();
    }

    public boolean updateCharger(int id, String name) throws InstanceNotFoundException, IllegalArgumentException {
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
