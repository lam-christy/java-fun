package easy;

import me.christylam.easy.FolderNavigation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FolderNavigationTest {
    @ParameterizedTest
    @MethodSource("getLogs")
    public void testNavigationToMainFromChildOk(String[] logs, int expected) {
        int actual = FolderNavigation.findLevelToMain(logs);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNavigationExceedsMainFolderOk() {
        String[] logs = {"d1/", "../", "../", "../"};
        int actual = FolderNavigation.findLevelToMain(logs);
        Assertions.assertEquals(0, actual);
    }

    @Test
    public void testNavigationExceedsMainFolderThanToChildOk() {
        String[] logs = {"folder1/", "../", "../", "../", "folder2/", "folder3"};
        int actual = FolderNavigation.findLevelToMain(logs);
        Assertions.assertEquals(2, actual);
    }

    private static Stream<Arguments> getLogs() {
        return Stream.of(
            Arguments.of(new String[]{"d1/", "d2/", "../", "d21/", "./"}, 2),
            Arguments.of(new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"}, 3),
            Arguments.of(new String[]{"d1/", "d2/", "./", "d3/", "../", "d4/", "d5/", "../", "d6/"}, 4)
        );
    }
}
