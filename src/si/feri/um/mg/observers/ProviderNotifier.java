package src.si.feri.um.mg.observers;

import src.si.feri.um.mg.vao.Charger;

import java.util.Observer;

public class ProviderNotifier implements ChargerObserver {
    @Override
    public void update(Charger charger, String user, String action) {
        System.out.print("\n\uD83C\uDFE2 Ponudnik obveščen: "+ charger.getName() +", "+ charger.getRegion() +" pri ponudniku ");
        System.out.print(charger.getProvider().getName());
        System.out.print(" je zdaj ");
        switch (action) {
            case "start":
                System.out.println("zasedena.");
                break;
            case "end":
                System.out.println("prosta.");
                break;
        }
        System.out.println("\n\n");
    }
}
