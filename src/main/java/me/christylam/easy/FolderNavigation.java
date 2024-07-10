package me.christylam.easy;

/**
 * <p>
 *     This is an easy question provided by LeetCode:
 *     <a href="https://leetcode.com/problems/crawler-log-folder/description/">Crawler Log Folder</a>
 * </p>
 * <p>
 *     The aim is to find the level of the current folder from the main folder, given the logs to trace when user performs an operation.
 * </p>
 *
 * @author Christy Lam
 */
public class FolderNavigation {
    /**
     * Function to find the level from the main folder to the current folder.
     *
     * @param logs the folder operations the user has performed
     * @return The number of level from the main folder to the current folder
     */
    public static int findLevelToMain(String[] logs) {
        int toMain = 0;
        for (String log : logs) {
            switch (log) {
                case "./":
                    continue;
                case "../":
                    toMain = Math.max(0, toMain - 1);
                    break;
                default:
                    toMain++;
            }
        }
        return toMain;
    }
}
