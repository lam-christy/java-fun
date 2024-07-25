package me.christylam.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     This is a hard question provided by LeetCode:
 *     <a href="https://leetcode.com/problems/find-xor-sum-of-all-pairs-bitwise-and">Find XOR Sum of All Pairs Bitwise AND</a>
 * </p>
 * <p>
 *     The aim is to find the bitwise AND among all the combinations of the elements among 2 arrays, then find the XOR sum of all the results.
 * </p>
 *
 * @author Christy Lam
 */
public class BitwiseANDThenXOR {
    /**
     * Function to find the XOR sum of the bitwise AND of all element combinations among 2 arrays.
     *
     * @param arr1 a non-empty array containing integers greater than 0
     * @param arr2 a non-empty array containing integers greater than 0
     * @return the XOR sum
     */
    public int getXORSum(int[] arr1, int[] arr2) {
        int ans1 = 0;
        int ans2 = 0;
        for (int a : arr1) {
            ans1 ^= a;
        }
        for (int b : arr2) {
            ans2 ^= b;
        }
        return ans1 & ans2;
    }
}