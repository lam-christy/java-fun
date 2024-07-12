package easy;

import me.christylam.easy.TwoArraysIntersection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TwoArraysIntersectionTest {
    private TwoArraysIntersection twoArraysIntersection;

    @BeforeEach
    public void setup() {
        twoArraysIntersection = new TwoArraysIntersection();
    }

    @ParameterizedTest
    @MethodSource("getArrays")
    public void testIntersectionOfTwoArraysOk(int[] nums1, int[] nums2, int[] expected) {
        int[] actual = twoArraysIntersection.intersect(nums1, nums2);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNoIntersection() {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {5, 6};
        int[] actual = twoArraysIntersection.intersect(num1, num2);
        Assertions.assertArrayEquals(new int[]{}, actual);
    }

    @Test
    public void testExactMatch() {
        int[] num1 = {1, 2, 2, 3};
        int[] num2 = {1, 2, 2, 3};
        int[] actual = twoArraysIntersection.intersect(num1, num2);
        Assertions.assertArrayEquals(new int[]{1, 2, 2, 3}, actual);
    }

    private static Stream<Arguments> getArrays() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 2, 1}, new int[]{2, 2}, new int[]{2, 2}),
            Arguments.of(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}, new int[]{9, 4})
        );
    }
}
