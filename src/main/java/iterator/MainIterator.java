package iterator;

import java.util.Iterator;

public class MainIterator {
    public static void main(String[] args) {
        Range r = new Range(10, 20, 1);
        for (Integer i: r) {
            System.out.println(i);
        }

        /*Iterator<Integer> iter =  r.iterator();

        while(iter.hasNext()) {
            System.out.println(iter.next());
        }*/

    }
}
