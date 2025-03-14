package src.si.feri.um.mg.iterators;

import src.si.feri.um.mg.vao.Charger;

import java.util.Iterator;
import java.util.List;

public class RegionChargerIterator implements Iterator<Charger> {

    private final Iterator<Charger> iterator;
    private String region;
    private Charger nextCharger;

    public RegionChargerIterator(List<Charger> chargers, final String region) {
        this.iterator = chargers.iterator();
        this.region = region;
        advance();
    }

    private void advance() {
        while (iterator.hasNext()) {
            Charger charger = iterator.next();
            if (charger.getRegion().equals(region)) {
                nextCharger = charger;
                return;
            }
        }
        nextCharger = null;
    }

    @Override
    public boolean hasNext() {
        return nextCharger != null;
    }

    @Override
    public Charger next() {
        Charger charger = nextCharger;
        advance();
        return charger;
    }

}
