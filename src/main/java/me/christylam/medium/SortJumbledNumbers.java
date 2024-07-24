package me.christylam.medium;

import java.util.Arrays;

/**
 * <p>
 *     This is a medium question provided by LeetCode:
 *     <a href="https://leetcode.com/problems/sort-the-jumbled-numbers">Sort the Jumbled Numbers</a>
 * </p>
 * <p>
 *     The aim is to replace digits within an array of numbers, provided by a digit mapping array, then sort them in order.
 * </p>
 *
 * @author Christy Lam
 */
public class SortJumbledNumbers {
    /**
     * Function to replace digits provided within the mapping array, among the array nums, then sort them in order, but return the original number in nums.
     *
     * @param mapping the array of digits to replace
     * @param nums the array of numbers to replace digit and to sort
     * @return The integer array that is sorted
     */

    public int[] sortJumbled(int[] mapping, int[] nums) {
        JumbledNum[] jumbledNums = new JumbledNum[nums.length];
        for (int i = 0; i < nums.length; i++) {
            jumbledNums[i] = formJumbledNum(nums[i], mapping);
        }

        return Arrays.stream(jumbledNums).sorted().mapToInt(n -> n.num).toArray();
    }

    private JumbledNum formJumbledNum(int num, int[] mapping) {
        String numStr = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        // Form the new jumbledNum with reference to the ASCII of the digit
        for (char s : numStr.toCharArray()) {
            sb.append(mapping[s - '0']);
        }
        // Remove '0' prefix
        while (!sb.isEmpty() && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        // Convert StringBuilder to int, 0 if empty
        int jumbledNum = sb.toString().isEmpty() ? 0 : Integer.parseInt(sb.toString());
        return new JumbledNum(num, jumbledNum);
    }
}

class JumbledNum implements Comparable<JumbledNum> {
    int num;
    int jumbledNum;

    JumbledNum(int num, int jumbledNum) {
        this.num = num;
        this.jumbledNum = jumbledNum;
    }

    @Override
    public int compareTo(JumbledNum jumbledNum) {
        return Integer.compare(this.jumbledNum, jumbledNum.jumbledNum);
    }
}
