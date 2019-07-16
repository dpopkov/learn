package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch02oop.progressions.Progression;

import java.util.Iterator;

public class R0717ProgressionIterator extends Progression implements Iterator<Long> {
    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Long next() {
        return super.nextValue();
    }
}
