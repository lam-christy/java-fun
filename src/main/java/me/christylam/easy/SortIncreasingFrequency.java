package me.christylam.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *     This is an easy question provided by LeetCode:
 *     <a href="https://leetcode.com/problems/sort-array-by-increasing-frequency/">Sort Array by Increasing Frequency</a>
 * </p>
 * <p>
 *     The aim is to sort an array with increasing frequency.
 *     If multiple numbers have the same frequency, they are sorted in descending order.
 * </p>
 *
 * @author Christy Lam
 */
public class SortIncreasingFrequency {
    /**
     * Function to find sorted array by increasing frequency.
     *
     * @param nums array of integers to sort
     * @return The array of the sorted integers
     */
    public int[] frequencySort(int[] nums) {
        // Similar to a counting sort, however as range is -100 <= n <= 100, 100 is added to the index.
        // 100 is later deduced to provide the correct value when creating the Frequency class instance
        int[] counts = new int[201];
        for (int num : nums) {
            counts[num + 100]++;
        }
        List<Frequency> frequencies = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0)
                frequencies.add(new Frequency(i - 100, counts[i]));
        }
        Collections.sort(frequencies);

        int[] sorted = new int[nums.length];
        for (int i = 0, j = 0; i < nums.length;) {
            int count = frequencies.get(j).count;
            // Each value count contributes to one element within the array
            while (count-- > 0) {
                sorted[i] = frequencies.get(j).value;
                i++;
            }
            j++;
        }
        return sorted;
    }
}

class Frequency implements Comparable<Frequency> {
    int value;
    int count;

    Frequency(int value, int count) {
        this.value = value;
        this.count = count;
    }

    @Override
    public int compareTo(Frequency frequency) {
        if (this.count > frequency.count) {
            return 1;
        } else if (this.count < frequency.count) {
            return -1;
        } else {
            return Integer.compare(frequency.value, this.value);
        }
    }
}