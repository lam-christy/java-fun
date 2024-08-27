package easy;

import me.christylam.easy.SeniorCitizens;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SeniorCitizenTest {
    private SeniorCitizens seniorCitizens;

    @BeforeEach
    public void setup() {
        seniorCitizens = new SeniorCitizens();
    }

    @ParameterizedTest
    @MethodSource("getArrays")
    public void testCheckNumberOfSeniorCitizensOk(String[] details, int expected) {
        int actual = seniorCitizens.countSeniors(details);
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> getArrays() {
        return Stream.of(
            Arguments.of(new String[]{"7868190130M7522","5303914400F9211","9273338290F4010"}, 2),
            Arguments.of(new String[]{"1313579440F2036","2921522980M5644"}, 0)
        );
    }
}