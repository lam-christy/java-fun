package hard;

import me.christylam.hard.BitwiseANDThenXOR;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BitwiseANDThenXORTest {
    BitwiseANDThenXOR bitwiseANDThenXOR;

    @BeforeEach
    public void setup() {
        bitwiseANDThenXOR = new BitwiseANDThenXOR();
    }

    @ParameterizedTest
    @MethodSource("getArrays")
    public void testRobotCollisionsOk(int[] arr1, int[] arr2, int expected) {
        int actual = bitwiseANDThenXOR.getXORSum(arr1, arr2);
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> getArrays() {
        return Stream.of(
            Arguments.of(new int[]{1,2,3}, new int[]{6,5}, 0),
            Arguments.of(new int[]{12}, new int[]{4}, 4)
        );
    }
}
