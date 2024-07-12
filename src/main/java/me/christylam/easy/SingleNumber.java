package me.christylam.easy;

import java.util.Arrays;

/**
 * <p>
 *     This is an easy question provided by LeetCode:
 *     <a href="https://leetcode.com/problems/single-number/">Single Number</a>
 * </p>
 * <p>
 *     The aim is to find the single number that does not have a duplicate among a non-empty array.
 *     The solution is implemented with a linear runtime complexity and use only constant extra space.
 * </p>
 *
 * @author Christy Lam
 */
public class SingleNumber {
    /**
     * Function to find the single number.
     *
     * @param nums array of integers
     * @return The single number that does not have a duplicate
     */
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce(0, (i, j) -> i ^ j);
    }
}
