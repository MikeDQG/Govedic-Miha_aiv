package src.si.feri.um.mg.chainOfResponsibility;


import src.si.feri.um.mg.vao.Charger;
import src.si.feri.um.mg.vao.User;

public interface ChargerHandler {
    void setNextHandler(ChargerHandler nextHandler);
    boolean handleRequest(Charger charger, User user);
}
