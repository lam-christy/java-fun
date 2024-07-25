package hard;

import me.christylam.hard.RobotCollisions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RobotCollisionsTest {
    RobotCollisions robotCollisions;

    @BeforeEach
    public void setup() {
        robotCollisions = new RobotCollisions();
    }

    @ParameterizedTest
    @MethodSource("robots")
    public void testRobotCollisionsOk(int[] positions, int[] healths, String directions, List<Integer> expected) {
        List<Integer> actual = robotCollisions.survivedRobotsHealths(positions, healths, directions);
        Assertions.assertEquals(expected.size(), actual.size());

        // Count should be 0 as all elements within expected should be equivalent to actual
        long count = IntStream.range(0, expected.size()).filter(i -> !expected.get(i).equals(actual.get(i))).count();
        Assertions.assertEquals(0, count);
    }

    private static Stream<Arguments> robots() {
        return Stream.of(
            Arguments.of(new int[]{5,4,3,2,1}, new int[]{2,17,9,15,10}, "RRRRR", new ArrayList<>(){{
                add(2);
                add(17);
                add(9);
                add(15);
                add(10);
            }}),
            Arguments.of(new int[]{3,5,2,6}, new int[]{10,10,15,12}, "RLRL", new ArrayList<>(){{
                add(14);
            }}),
            Arguments.of(new int[]{1,2,5,6}, new int[]{10,10,11,11}, "RLRL", new ArrayList<>()),
            Arguments.of(new int[]{5,1,2,3,4}, new int[]{5,11,13,12,13}, "RRRRL", new ArrayList<>(){{
                add(5);
                add(11);
                add(12);
            }}),
            Arguments.of(new int[]{5,1,2,3,4}, new int[]{5,11,12,12,13}, "RRRRL", new ArrayList<>(){{
                add(5);
                add(11);
            }})
        );
    }
}
