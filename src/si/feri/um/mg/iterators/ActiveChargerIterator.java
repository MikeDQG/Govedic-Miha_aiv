package src.si.feri.um.mg.iterators;

import src.si.feri.um.mg.vao.Charger;

import java.util.Iterator;
import java.util.List;

public class ActiveChargerIterator implements Iterator<Object> {
    private final Iterator<Charger> iterator;
    private Charger nextCharger;
    private boolean isActive;

    public ActiveChargerIterator(List<Charger> chargers, boolean isActive) {
        iterator = chargers.iterator();
        this.isActive = isActive;
        advance();
    }

    private void advance() {
        while (iterator.hasNext()) {
            Charger charger = iterator.next();
            if (charger.isActive() == isActive) {
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
        Charger currentCharger = nextCharger;
        advance();
        return currentCharger;
    }
}
