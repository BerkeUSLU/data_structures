import collections.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLinkedList {

    @Test
    void testLinkedList(){
        LinkedList<Integer> ll = new LinkedList<>();
        ll.append(10);
        ll.append(20);
        Integer[] arr = ll.toArray(Integer.class);
        //ll.toArray(new Integer[0])
        assertArrayEquals(new Integer[]{10, 20}, arr);

    }

}
