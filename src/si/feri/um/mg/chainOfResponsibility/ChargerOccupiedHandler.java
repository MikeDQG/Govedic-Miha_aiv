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
    public boolean handleRequest(Charger charger, User user) {
        if (!charger.isActive()) {
            if (nextHandler != null) {
                return nextHandler.handleRequest(charger, user);
            }
            return true;
        }
        System.out.println("polnilnica je zasedena – polnjenje zavrnjeno");
        return false;
    }
}
