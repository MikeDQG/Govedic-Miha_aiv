package src.si.feri.um.mg.chainOfResponsibility;

import src.si.feri.um.mg.vao.Charger;
import src.si.feri.um.mg.vao.User;

public class ChargerCompatibleHandler implements ChargerHandler {
    private ChargerHandler nextHandler;

    @Override
    public void setNextHandler(ChargerHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Charger charger, User user) {
        if (user.getCarType().equalsIgnoreCase(charger.getAcceptedType())) {
            charger.setCurrentUser(user);
//            System.out.println("cartype cool");
            if (nextHandler != null) {
                nextHandler.handleRequest(charger, user);
            }
        } else charger.setCurrentUser(null);
    }
}
