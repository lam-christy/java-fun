package me.christylam.easy;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * <p>
 *     This is an easy question provided by LeetCode:
 *     <a href="https://leetcode.com/problems/kth-distinct-string-in-an-array">Kth Distinct String in an Array</a>
 * </p>
 * <p>
 *     The aim is to find the kth distinct string within an array, in the order they are provided.
 * </p>
 *
 * @author Christy Lam
 */
public class KThDistinctString {
    /**
     * Function to find the kth distinct string within an array, in the order they are provided.
     *
     * @param arr an array of strings
     * @param k the index of the distinct string
     * @return the kth distinct string within the array arr
     */
    public String kthDistinct(String[] arr, int k) {
        var strings = new LinkedHashSet<String>();
        var seen = new HashSet<String>();
        for (String s : arr) {
            if (seen.contains(s))
                continue;;
            if (strings.contains(s)) {
                seen.add(s);
                strings.remove(s);
            } else {
                strings.add(s);
            }
        }

        int count = 1;
        for (String s : strings) {
            if (count == k)
                return s;
            count++;
        }
        return "";
    }
}
