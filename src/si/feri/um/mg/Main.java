package src.si.feri.um.mg;

import src.si.feri.um.mg.dao.ChargerDAO;
import src.si.feri.um.mg.dao.ProviderDAO;
import src.si.feri.um.mg.vao.Charger;
import src.si.feri.um.mg.vao.Provider;

public class Main {
    public static void main(String[] args) {
        ProviderDAO providerDAO = new ProviderDAO();
        ChargerDAO chargerDAO = new ChargerDAO();

        Provider p1 = new Provider("Franc", "franc@example.com");
        Provider p2 = new Provider("Joze", "joze@example.com");

        providerDAO.insertProvider(p1);
        providerDAO.insertProvider(p2);

        Charger c1 = new Charger("Polnilnica FERI", 1, p1);
        Charger c2 = new Charger("Polnilnica TPC", 2, p1);
        Charger c3 = new Charger("Polnilnica Park", 3, p2);

        chargerDAO.insertCharger(c1);
        chargerDAO.insertCharger(c2);
        chargerDAO.insertCharger(c3);

        p1.addCharger(c1);
        p1.addCharger(c2);
        p2.addCharger(c3);

        // Prikaz providerjev
        System.out.println("Vsi ponudniki:");
        providerDAO.getProviders().forEach(System.out::println);

        // Prikaz polnilnic
        System.out.println("\nVse polnilnice:");
        chargerDAO.getAllChargers().forEach(System.out::println);

        // Update provider
        System.out.println("\nPosodobi ponudnika: Franc -> Francek");
        System.out.println(providerDAO.getProviderByEmail("franc@example.com"));
        providerDAO.updateProvider("franc@example.com", "Francek");
        System.out.println(providerDAO.getProviderByEmail("franc@example.com"));

        // All provider's chargers
        System.out.println("\nVse polmnilnice ponudnika: Francek");
        p1.getChargers().forEach(System.out::println);

        // Update charger
        System.out.println("\nPosodobi polnilnico: TPC -> Europark");
        System.out.println(chargerDAO.getChargerById(2));
        chargerDAO.updateCharger(2, "Europark");
        System.out.println(chargerDAO.getChargerById(2));

        // Delete charger
        System.out.println("\nIzbrisi polnilnico: Park");
        System.out.println(chargerDAO.getChargerById(3));
        chargerDAO.deleteCharger(3);
        System.out.println("Polnilnica id=3");
        System.out.println(chargerDAO.getChargerById(3));
        System.out.println("Vse polnilnice");
        chargerDAO.getAllChargers().forEach(System.out::println);

        // Add provider
        System.out.println("\nDodaj ponudnika: Marko");
        System.out.println("Vsi ponudniki:");
        providerDAO.getProviders().forEach(System.out::println);
        Provider p3 = new Provider("Marko", "marko@example.com");
        providerDAO.insertProvider(p3);
        System.out.println("Vsi ponudniki:");
        providerDAO.getProviders().forEach(System.out::println);


        // Delete provider
        System.out.println("\nIzbrisi ponudnika: Marko");
        System.out.println(providerDAO.getProviderByEmail("marko@example.com"));
        providerDAO.deleteProvider("marko@example.com");
        System.out.println("Ponudnik marko@example.com:");
        System.out.println(providerDAO.getProviderByEmail("marko@example.com"));
        System.out.println("Vsi ponudniki:");
        providerDAO.getProviders().forEach(System.out::println);

    }
}
