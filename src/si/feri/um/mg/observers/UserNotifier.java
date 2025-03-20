package src.si.feri.um.mg.observers;

import src.si.feri.um.mg.vao.Charger;

public class UserNotifier implements ChargerObserver {
    @Override
    public void update(Charger charger, String user, String action) {
        switch (action) {
            case "start":
                System.out.println("📩 [EMAIL] Od: noreply@chargingstations.com");
                System.out.println("📩 Za: " + user);
                System.out.println("📩 Zadeva: Polnjenje se je začelo! ⚡");
                System.out.println();
                System.out.println("Pozdravljeni,");
                System.out.println();
                System.out.println("vaše polnjenje na polnilnici " + charger.getName() + " se je uspešno začelo.");
                System.out.println("🚗 Moč polnjenja: " + charger.getPowerOutput() + " kW");
                System.out.println();
                System.out.println("Lep pozdrav,");
                System.out.println(charger.getProvider().getName());
                System.out.println("-------------------------------------------------");
                System.out.println();
                break;

            case "end":
                System.out.println("📩 [EMAIL] Od: noreply@chargingstations.com");
                System.out.println("📩 Za: user@example.com");
                System.out.println("📩 Zadeva: Polnjenje končano! ✅");
                System.out.println();
                System.out.println("Pozdravljeni,");
                System.out.println();
                System.out.println("vaše polnjenje na polnilnici " + charger.getName() + " je končano.");
                System.out.println("🔌");
                System.out.println();
                System.out.println("Lep pozdrav,");
                System.out.println(charger.getProvider().getName());
                System.out.println("-------------------------------------------------");
                System.out.println();
                break;
        }
    }
}
