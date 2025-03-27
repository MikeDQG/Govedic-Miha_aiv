package src.si.feri.um.mg.chainOfResponsibility;

import src.si.feri.um.mg.vao.Charger;
import src.si.feri.um.mg.vao.User;

public class UserBalanceCheckHandler implements ChargerHandler {
    ChargerHandler nextHandler;

    @Override
    public void setNextHandler(ChargerHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean handleRequest(Charger charger, User user) {
        if (user.getBalance() >= charger.getCost()) {
            if (nextHandler != null) {
                return nextHandler.handleRequest(charger, user);
            }
            return true;
        }
        System.out.println("Uporabnik "+user.getName()+" nima dovolj sredstev – polnjenje zavrnjeno.");
        return false;
    }
}
