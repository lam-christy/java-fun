package me.christylam.medium;

/**
 * <p>
 *     This is a medium question provided by LeetCode:
 *     <a href="https://leetcode.com/problems/maximum-score-from-removing-substrings/description/">Maximum Score From Removing Substrings</a>
 * </p>
 * <p>
 *     The aim is to find the maximum score from removing substrings "ab" and "ba".
 * </p>
 *
 * @author Christy Lam
 */
public class SubstringsRemovalMaxScore {
    /**
     * Function to find the maximum score from removing substrings "ab" and "ba", where x is the score for "ab" and y is the score for "ba".
     *
     * @param s the string to find the maximum score
     * @param x the score for every "ab"
     * @param y the score for every "ba"
     * @return The maximum score
     */

    public int maximumGain(String s, int x, int y) {
        int score = 0;
        int aCount = 0;
        int bCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                if (x < y && bCount > 0) {
                    score += y;
                    bCount--;
                } else {
                    aCount++;
                }
            } else if (s.charAt(i) == 'b') {
                if (y < x && aCount > 0) {
                    score += x;
                    aCount--;
                } else {
                    bCount++;
                }
            } else {
                // Multiply by the minimum of x and y, as the substring with the greater value would have been captured by the code above
                score += Math.min(aCount, bCount) * Math.min(x, y);
                aCount = 0;
                bCount = 0;
            }
        }
        score += Math.min(aCount, bCount) * Math.min(x, y);

        return score;
    }
}
