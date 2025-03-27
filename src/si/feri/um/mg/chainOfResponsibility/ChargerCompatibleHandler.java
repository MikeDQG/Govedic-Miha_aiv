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
    public boolean handleRequest(Charger charger, User user) {
        if (user.getCarType().equalsIgnoreCase(charger.getAcceptedType())) {
            if (nextHandler != null) {
                return nextHandler.handleRequest(charger, user);
            }
            return true;
        }
        System.out.println("vozilo "+user.getCarType()+" ni kompatibilno s polnilnico "+charger.getAcceptedType());
        return false;
    }
}
