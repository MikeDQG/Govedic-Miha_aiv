package src.si.feri.um.mg.iterators;

import src.si.feri.um.mg.vao.Charger;

import java.util.Iterator;
import java.util.List;

public class ChargerIterator implements Iterator<Charger> {
    private final Iterator<Charger> iterator;

    public ChargerIterator(List<Charger> chargers) {
        this.iterator = chargers.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Charger next() {
        return iterator.next();
    }
}
