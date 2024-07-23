package easy;

import me.christylam.easy.SortPeople;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SortPeopleTest {
    private SortPeople sortPeople;

    @BeforeEach
    public void setup() {
        sortPeople = new SortPeople();
    }

    @ParameterizedTest
    @MethodSource("getPeople")
    public void testSortPeopleOk(String[] names, int[] heights, String[] expected) {
        String[] actual = sortPeople.sortPeople(names, heights);
        Assertions.assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> getPeople() {
        return Stream.of(
            Arguments.of(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170}, new String[]{"Mary", "Emma", "John"}),
            Arguments.of(new String[]{"Alice", "Bob", "Bob"}, new int[]{155, 185, 150}, new String[]{"Bob", "Alice", "Bob"})
        );
    }
}
