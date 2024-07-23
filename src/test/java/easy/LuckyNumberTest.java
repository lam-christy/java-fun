package easy;

import me.christylam.easy.LuckyNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class LuckyNumberTest {
    private LuckyNumber luckyNumber;

    @BeforeEach
    public void setup() {
        luckyNumber = new LuckyNumber();
    }

    @ParameterizedTest
    @MethodSource("getMatrix")
    public void testGetLuckyNumberOk(int[][] matrix, int expected) {
        List<Integer> actual = luckyNumber.luckyNumbers(matrix);
        Assertions.assertEquals(expected, actual.getFirst());
    }

    private static Stream<Arguments> getMatrix() {
        return Stream.of(
            Arguments.of(new int[][]{{3,7,8},{9,11,13},{15,16,17}}, 15),
            Arguments.of(new int[][]{{1,10,4,2},{9,3,8,7},{15,16,17,12}}, 12),
            Arguments.of(new int[][]{{7,8},{1,2}}, 7),
            Arguments.of(new int[][]{{3,6},{7,1},{5,2},{4,8}}, -1)
        );
    }
}
