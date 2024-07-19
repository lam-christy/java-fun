package me.christylam.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     This is an easy question provided by LeetCode:
 *     <a href="https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/">Lucky Numbers in a Matrix</a>
 * </p>
 * <p>
 *     The aim is to find the lucky number that is the minimum among the row, and maximum among the column.
 * </p>
 *
 * @author Christy Lam
 */
public class LuckyNumber {
    /**
     * Function to find the lucky number that is the minimum among the row, and maximum among the column.
     *
     * @param matrix grid of numbers in a 2-dimensional matrix
     * @return The list containing the lucky number, -1 is returned if lucky number does not exist
     */
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckyNum = new ArrayList<>();
        luckyNum.add(findLuckyNum(matrix));
        return luckyNum;

    }

    private int findLuckyNum(int[][] matrix) {
        outer:
        for (int[] row : matrix) {
            int min = row[0];
            int minJ = 0;
            for (int j = 1; j < matrix[0].length; j++) {
                if (row[j] < min) {
                    min = row[j];
                    minJ = j;
                }
            }
            int max = row[minJ];
            for (int[] innerRow : matrix) {
                if (innerRow[minJ] > max) {
                    continue outer;
                }
            }
            return max;
        }
        return -1;
    }
}
