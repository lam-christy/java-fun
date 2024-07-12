package easy;

import me.christylam.easy.SingleNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SingleNumberTest {
    private SingleNumber singleNumber;

    @BeforeEach
    public void setup() {
        singleNumber = new SingleNumber();
    }

    @ParameterizedTest
    @MethodSource("getArrays")
    public void testSingleNumberOk(int[] nums, int expected) {
        int actual = singleNumber.singleNumber(nums);
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> getArrays() {
        return Stream.of(
            Arguments.of(new int[]{2, 2, 1}, 1),
            Arguments.of(new int[]{4, 1, 2, 1, 2}, 4),
            Arguments.of(new int[]{1}, 1)
        );
    }
}
