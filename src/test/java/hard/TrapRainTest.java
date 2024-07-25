package hard;

import me.christylam.hard.TrapRain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TrapRainTest {
    TrapRain trapRain;

    @BeforeEach
    public void setup() {
        trapRain = new TrapRain();
    }

    @ParameterizedTest
    @MethodSource("getHeight")
    public void testTrappedRainAmountOk(int[] height, int expected) {
        int actual = trapRain.trap(height);
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> getHeight() {
        return Stream.of(
            Arguments.of(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}, 6),
            Arguments.of(new int[]{4,2,0,3,2,5}, 9)
        );
    }
}
