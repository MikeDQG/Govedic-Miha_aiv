package src.si.feri.um.mg;

import src.si.feri.um.mg.dao.ChargerDAO;
import src.si.feri.um.mg.dao.ProviderDAO;
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


            Charger c1 = chargerService.createCharger("Polnilnica FERI", 1, p1);
            Charger c2 = chargerService.createCharger("Polnilnica TPC", 2, p1);
            Charger c3 = chargerService.createCharger("Polnilnica Park", 3, p2);


            p1.addCharger(c1);
            p1.addCharger(c2);
            p2.addCharger(c3);

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
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
