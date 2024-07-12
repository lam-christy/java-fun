package medium;

import me.christylam.medium.ReverseSubstrings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ReverseSubstringsTest {
    ReverseSubstrings reverseSubstrings;

    @BeforeEach
    public void setup() {
        reverseSubstrings = new ReverseSubstrings();
    }

    @Test
    public void testReverseSubstringOk() {
        String s = "(abcd)";
        String actual = reverseSubstrings.reverseParentheses(s);
        Assertions.assertEquals("dcba", actual);
    }

    @ParameterizedTest
    @MethodSource("nestedParentheses")
    public void testReversSubstringsNestedParenthesesOk(String s, String expected) {
        String actual = reverseSubstrings.reverseParentheses(s);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testReverseSubstringWithoutParenthesesOk() {
        String s = "abc";
        String actual = reverseSubstrings.reverseParentheses(s);
        Assertions.assertEquals("abc", actual);
    }

    private static Stream<Arguments> nestedParentheses() {
        return Stream.of(
            Arguments.of("(u(love)i)", "iloveu"),
            Arguments.of("(ed(et(oc))el)", "leetcode"),
            Arguments.of("(a(b(cz(d(e))f)g)h)", "hbfdezcga")
        );
    }
}
