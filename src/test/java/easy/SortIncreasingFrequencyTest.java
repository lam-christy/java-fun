package easy;

import me.christylam.easy.SortIncreasingFrequency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SortIncreasingFrequencyTest {
    private SortIncreasingFrequency sortIncreasingFrequency;

    @BeforeEach
    public void setup() {
        sortIncreasingFrequency = new SortIncreasingFrequency();
    }

    @ParameterizedTest
    @MethodSource("getArrays")
    public void testSortIncreasingFrequencyOk(int[] nums, int[] expected) {
        int[] actual = sortIncreasingFrequency.frequencySort(nums);
        Assertions.assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> getArrays() {
        return Stream.of(
            Arguments.of(new int[]{1,1,2,2,2,3}, new int[]{3,1,1,2,2,2}),
            Arguments.of(new int[]{2,3,1,3,2}, new int[]{1,3,3,2,2}),
            Arguments.of(new int[]{-1,1,-6,4,5,-6,1,4,1}, new int[]{5,-1,4,4,-6,-6,1,1,1})
        );
    }
}
