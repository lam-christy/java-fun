package me.christylam.medium;

/**
 * <p>
 *     This is a medium question provided by LeetCode:
 *     <a href="https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/">Reverse Substrings Between Each Pair of Parentheses</a>
 * </p>
 * <p>
 *     The aim is to reverse the strings in each pair of matching parentheses, starting from the inner most one.
 * </p>
 *
 * @author Christy Lam
 */
public class ReverseSubstrings {
    private int index = 0;
    /**
     * Function to find the reverse of strings in each pair of matching parentheses.
     *
     * @param s the string containing parentheses to perform the reverse operation(s)
     * @return The string after each substring within the matching parentheses are reversed
     */

    public String reverseParentheses(String s) {
        return reverseSubstrings(s);
    }

    private String reverseSubstrings(String s) {
        var sb = new StringBuilder();

        while (index < s.length()) {
            if (s.charAt(index) == ')') {
                index++;
                return sb.reverse().toString();
            } else if (s.charAt(index) == '(') {
                index++;
                sb.append(reverseSubstrings(s));
            } else {
                sb.append(s.charAt(index));
                index++;
            }
        }

        return sb.toString();
    }
}
