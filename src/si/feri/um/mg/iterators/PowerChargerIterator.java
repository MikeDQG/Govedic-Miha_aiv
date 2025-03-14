package src.si.feri.um.mg.iterators;

import src.si.feri.um.mg.vao.Charger;

import java.util.Iterator;
import java.util.List;

public class PowerChargerIterator implements Iterator<Charger> {

    private final Iterator<Charger> iterator;
    private double minPower;
    private Charger nextCharger;

    public PowerChargerIterator(List<Charger> chargers, double power) {
        this.iterator = chargers.iterator();
        this.minPower = power;
        advance();
    }

    private void advance() {
        while (iterator.hasNext()) {
            Charger charger = iterator.next();
            if (charger.getPowerOutput() >= minPower) {
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
