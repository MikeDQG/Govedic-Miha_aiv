package src.si.feri.um.mg;

import src.si.feri.um.mg.dao.ChargerDAO;
import src.si.feri.um.mg.dao.ProviderDAO;
import src.si.feri.um.mg.iterators.*;
import src.si.feri.um.mg.service.ChragerService;
import src.si.feri.um.mg.service.ProviderService;
import src.si.feri.um.mg.vao.Charger;
import src.si.feri.um.mg.vao.Provider;

public class Main {
    public static void main(String[] args) {
        ProviderService providerService = new ProviderService();
        ChragerService chargerService = new ChragerService();

        try {
            Provider p1 = providerService.createProvider("Franc", "franc@example.com");
            Provider p2 = providerService.createProvider("Joze", "joze@example.com");


            Charger c1 = chargerService.createCharger("Polnilnica FERI", 1, p1, 50, "Maribor");
            Charger c2 = chargerService.createCharger("Polnilnica TPC", 2, p1, 25, "Maribor");
            Charger c3 = chargerService.createCharger("Polnilnica Park", 3, p2, 36, "Ljubljana");
            Charger c4 = chargerService.createCharger("Polnilnica FERI", 4, p1, 50, "Maribor");
            Charger c5 = chargerService.createCharger("Polnilnica TPC", 5, p1, 25, "Maribor");
            Charger c6 = chargerService.createCharger("Polnilnica Park", 6, p2, 36, "Ljubljana");

            c4.setActive(false);
            c6.setActive(false);


            p1.addCharger(c1);
            p1.addCharger(c2);
            p2.addCharger(c3);
            p1.addCharger(c4);
            p1.addCharger(c5);
            p1.addCharger(c6);


            // Prikaz providerjev
            System.out.println("Vsi ponudniki:");
            providerService.getAllProviders().forEach(System.out::println);

            // Prikaz polnilnic
            System.out.println("\nVse polnilnice:");
            chargerService.getAllChargers().forEach(System.out::println);

            // Update provider
            System.out.println("\nPosodobi ponudnika: Franc -> Francek");
            try {
                System.out.println(providerService.getProvider("franc@example.com"));
                System.out.println(providerService.updateProvider("franc@example.com", "Francek"));
                System.out.println(providerService.getProvider("franc@example.com"));
            } catch (InstanceNotFoundException e) {
                System.out.println(e.getMessage());
            }

            // All provider's chargers
            System.out.println("\nVse polmnilnice ponudnika: Francek");
            p1.getChargers().forEach(System.out::println);

            // Update charger
            System.out.println("\nPosodobi polnilnico: TPC -> Europark");
            try {
                System.out.println(chargerService.getChargerById(2));
                chargerService.updateCharger(2, "Europark");
                System.out.println(chargerService.getChargerById(2));
            } catch (InstantiationException e) {
                System.out.println(e.getMessage());
            }

            // Delete charger
            System.out.println("\nIzbrisi polnilnico: Park");
            try {
                System.out.println(chargerService.getChargerById(3));
                chargerService.deleteCharger(3);
                System.out.println("Polnilnica id=3");
                System.out.println(chargerService.getChargerById(3));
            } catch (InstanceNotFoundException | InstantiationException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Vse polnilnice");
            chargerService.getAllChargers().forEach(System.out::println);

            // Add provider
            System.out.println("\nDodaj ponudnika: Marko");
            System.out.println("Vsi ponudniki:");
            providerService.getAllProviders().forEach(System.out::println);
            providerService.createProvider("Marko", "marko@example.com");
            System.out.println("Vsi ponudniki:");
            providerService.getAllProviders().forEach(System.out::println);


            // Delete provider
            System.out.println("\nIzbrisi ponudnika: Marko");
            try {
                System.out.println(providerService.getProvider("marko@example.com"));
                System.out.println(providerService.deleteProvider("marko@example.com"));
                System.out.println("Ponudnik marko@example.com:");
                System.out.println(providerService.getProvider("marko@example.com"));
            } catch (InstanceNotFoundException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Vsi ponudniki:");
            providerService.getAllProviders().forEach(System.out::println);

            // Test ChargerIterator
            System.out.println("\nChargerIterator:");
            ChargerIterator chargerIterator = new ChargerIterator(p1.getChargers());
            while (chargerIterator.hasNext()) {
                System.out.println(chargerIterator.next().getName());
            }

            // Test ActiveChargerIterator
            System.out.println("\nActiveChargerIterator:");
            ActiveChargerIterator activeChargerIterator = new ActiveChargerIterator(p1.getChargers(), true);
            while (activeChargerIterator.hasNext()) {
                System.out.println(activeChargerIterator.next());
            }

            // Test PowerChargerIterator
            System.out.println("\nPowerChargerIterator, minPower 40kW:");
            PowerChargerIterator powerChargerIterator = new PowerChargerIterator(p1.getChargers(), 40);
            while (powerChargerIterator.hasNext()) {
                System.out.println(powerChargerIterator.next());
            }

            // Test RegionChargerIterator
            System.out.println("\nRegionChargerIterator, region 'Maribor'");
            RegionChargerIterator regionChargerIterator = new RegionChargerIterator(p1.getChargers(), "Maribor");
            while (regionChargerIterator.hasNext()) {
                System.out.println(regionChargerIterator.next());
            }

            // Test All Chargers from all providers sorted alphabetically
            System.out.println("\nAll chargers alphabetically:");
            AllChargersAlphabetically allChargersAlphabetically = new AllChargersAlphabetically(providerService.getAllProviders());
            while (allChargersAlphabetically.hasNext()) {
                System.out.println(allChargersAlphabetically.next());
            }


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
