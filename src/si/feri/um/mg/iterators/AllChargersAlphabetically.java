package src.si.feri.um.mg.iterators;

import src.si.feri.um.mg.vao.Charger;
import src.si.feri.um.mg.vao.Provider;

import java.util.*;

public class AllChargersAlphabetically implements Iterator<Charger> {

    private final Iterator<Charger> iterator;
    private Charger nextCharger;

    public AllChargersAlphabetically(List<Provider> providers) {

        iterator = sortChargers(extractChargers(providers)).iterator();
    }

    private List<Charger> extractChargers(List<Provider> providers) {
        List<Charger> chargers = new ArrayList<Charger>();

        for (Provider provider : providers) {
            chargers.addAll(provider.getChargers());
        }

        return chargers;
    }

    private List<Charger> sortChargers(List<Charger> chargers) {
        chargers.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        return chargers;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Charger next() {
        nextCharger = iterator.next();
        return nextCharger;
    }

}
