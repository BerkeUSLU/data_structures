package iterator;

import java.util.Iterator;
import java.lang.*;

public class Range implements Iterable<Integer>{
    private final int start;
    private final int stop;
    private final int step;

    public Range(int start, int stop, int step) {
        this.start = start;
        this.stop = stop;
        this.step = step;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator();
    }

    class RangeIterator implements Iterator<Integer>{
        private int actual = start;

        @Override
        public boolean hasNext() {
            return actual < stop;
        }

        @Override
        public Integer next() {
            int temp = actual;
            actual += step;
            return temp;
        }
    }
}
