package src.si.feri.um.mg.chainOfResponsibility;

import src.si.feri.um.mg.vao.Charger;
import src.si.feri.um.mg.vao.User;

public class ChargerOccupiedHandler implements ChargerHandler {
    private ChargerHandler nextHandler;

    @Override
    public void setNextHandler(ChargerHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Charger charger, User user) {
        if (!charger.isActive()) {
            charger.setCurrentUser(user);
//            System.out.println("active cool");
            if (nextHandler != null) {
                nextHandler.handleRequest(charger, user);
            }
        } else charger.setCurrentUser(null);
    }
}
