package iterator;

import java.util.Iterator;

public class CycleIterator implements Iterable<Integer> {
    private final int begin;
    private final int end;
    private final int step;

    public CycleIterator(int begin, int end, int step) {
        this.begin = begin;
        this.end = end;
        this.step = step;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int indexFollower = begin;
            @Override
            public boolean hasNext() {
                if (indexFollower == end) {
                    indexFollower = begin;
                }
                return true;
            }

            @Override
            public Integer next() {
                int result = indexFollower;
                indexFollower += step;
                return result;
            }
        };
        //begin end step
    }

    public static void main(String[] args) {
        CycleIterator it = new CycleIterator(10,20,1);
        for (Integer i: it) {
             System.out.println(i);
        }
    }

}
