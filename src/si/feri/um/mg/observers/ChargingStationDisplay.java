package src.si.feri.um.mg.observers;

import src.si.feri.um.mg.iterators.ActiveChargerIterator;
import src.si.feri.um.mg.service.ChargerService;
import src.si.feri.um.mg.vao.Charger;

import java.util.List;

public class ChargingStationDisplay implements ChargerObserver {
    @Override
    public void update(Charger charger, String user, String action) {
        System.out.println("\n\uD83D\uDCDF [Zaslon polnilne postaje] Trenutno stanje polnilnic:");

        ChargerService ch = new ChargerService();
        List<Charger> chargers = ch.getAllChargers();

        System.out.println("\n✅ Proste polnilnice:");
        ActiveChargerIterator proste = new ActiveChargerIterator(chargers, false);
        while (proste.hasNext()) {
            System.out.println(proste.next().onlyChargerToString());
        }


//        chargers2.forEach(System.out::println);
        System.out.println("\n⛔ Zasedene polnilnice:");
        ActiveChargerIterator zasedene = new ActiveChargerIterator(chargers, true);
        while (zasedene.hasNext()) {
            System.out.println(zasedene.next().onlyChargerToString());
        }

        System.out.println("\n\n");
    }
}
