import iterator.Range;
import org.junit.jupiter.api.Test;

public class TestRange {

    @Test
    void testRangeConstructor() {
        Range r = new Range(10, 20, 1);
        for (Integer i: r) {
            System.out.println(i);
        }
    }

}
