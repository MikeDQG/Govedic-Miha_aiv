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
    public void handleRequest(Charger charger, User user) {
        if (user.getBalance() >= charger.getCost()) {
            charger.setCurrentUser(user);
//            System.out.println("balance cool");
            if (nextHandler != null) {
                nextHandler.handleRequest(charger, user);
            }
        } else charger.setCurrentUser(null);
    }
}
