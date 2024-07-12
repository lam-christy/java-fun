package medium;

import me.christylam.medium.SubstringsRemovalMaxScore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SubstringsRemovalMaxScoreTest {
    SubstringsRemovalMaxScore substringsRemovalMaxScore;

    @BeforeEach
    public void setup() {
        substringsRemovalMaxScore = new SubstringsRemovalMaxScore();
    }

    @Test
    public void testSubstringRemovalMaxScoreOnlyABOk() {
        String s = "aabbaaxybbaabb";
        int x = 5;
        int y = 4;
        int actual = substringsRemovalMaxScore.maximumGain(s, x, y);
        Assertions.assertEquals(20, actual);
    }

    @Test
    public void testSubstringRemovalMaxScoreOnlyBAOk() {
        String s = "bbaaaaxcdbae";
        int x = 5;
        int y = 4;
        int actual = substringsRemovalMaxScore.maximumGain(s, x, y);
        Assertions.assertEquals(12, actual);
    }

    @Test
    public void testSubstringRemovalMaxScoreBothABAndBAOk() {
        String s = "cdbcbbaaabab";
        int x = 4;
        int y = 5;
        int actual = substringsRemovalMaxScore.maximumGain(s, x, y);
        Assertions.assertEquals(19, actual);
    }

    @Test
    public void testSubstringRemovalMaxScoreABAndBASameScoreOk() {
        String s = "cdbcbbaaabab";
        int x = 5;
        int y = 5;
        int actual = substringsRemovalMaxScore.maximumGain(s, x, y);
        Assertions.assertEquals(20, actual);
    }

//    @ParameterizedTest
//    @MethodSource("nestedParentheses")
//    public void testReversSubstringsNestedParenthesesOk(String s, String expected) {
//        String actual = reverseSubstrings.reverseParentheses(s);
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testReverseSubstringWithoutParenthesesOk() {
//        String s = "abc";
//        String actual = reverseSubstrings.reverseParentheses(s);
//        Assertions.assertEquals("abc", actual);
//    }

    private static Stream<Arguments> nestedParentheses() {
        return Stream.of(
            Arguments.of("(u(love)i)", "iloveu"),
            Arguments.of("(ed(et(oc))el)", "leetcode"),
            Arguments.of("(a(b(cz(d(e))f)g)h)", "hbfdezcga")
        );
    }
}
