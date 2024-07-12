package medium;

import me.christylam.medium.SubstringsRemovalMaxScore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
