package medium;

import me.christylam.medium.SortJumbledNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SortJumbledNumbersTest {
    private SortJumbledNumbers sortJumbledNumbers;

    @BeforeEach
    public void setup() {
        sortJumbledNumbers = new SortJumbledNumbers();
    }

    @ParameterizedTest
    @MethodSource("getArrays")
    public void testSortJumbledNumbersOk(int[] mapping, int[] nums, int[] expected) {
        int[] actual = sortJumbledNumbers.sortJumbled(mapping, nums);
        Assertions.assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> getArrays() {
        return Stream.of(
            Arguments.of(new int[]{8,9,4,0,2,1,3,5,7,6}, new int[]{991,338,38}, new int[]{338,38,991}),
            Arguments.of(new int[]{0,1,2,3,4,5,6,7,8,9}, new int[]{789,456,123}, new int[]{123, 456, 789}),
            Arguments.of(new int[]{0,1,2,3,4,5,6,7,8,9}, new int[]{0,999999999}, new int[]{0,999999999})
        );
    }
}
