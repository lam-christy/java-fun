package hard;

import me.christylam.hard.MedianFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MedianFinderTest {
    MedianFinder medianFinder;

    @BeforeEach
    public void setup() {
        medianFinder = new MedianFinder();
    }

    @Test
    public void testMedianFinderOk() {
        double median = medianFinder.findMedian();
        Assertions.assertEquals(0.0, median);

        medianFinder.addNum(1);
        median = medianFinder.findMedian();
        Assertions.assertEquals(1.0, median);

        medianFinder.addNum(2);
        median = medianFinder.findMedian();
        Assertions.assertEquals(1.5, median);

        medianFinder.addNum(3);
        median = medianFinder.findMedian();
        Assertions.assertEquals(2.0, median);
    }
}
