package me.christylam.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     This is a hard question provided by LeetCode:
 *     <a href="https://leetcode.com/problems/find-median-from-data-stream">Find Median from Data Stream</a>
 * </p>
 * <p>
 *     The aim is to go through the input data stream and compute the following functions accordingly:
 * </p>
 * <p>
 *     "MedianFinder" - initializes the MedianFinder object;
 *     "addNum(int num)" - adds the integer num from the data stream;
 *     "findMedian()" - returns the median of all elements so far.
 * </p>
 *
 * @author Christy Lam
 */
public class MedianFinder {
    private final List<Integer> nums;

    public MedianFinder() {
        nums = new ArrayList<>();
    }

    /**
     * Function to add the integer num to the nums array list, with O(log n).
     *
     * @param num the integer to add to the nums array list
     */
    public void addNum(int num) {
        binarySearchForIndex(num);
    }

    private void binarySearchForIndex(int num) {
        int low = 0;
        int high = nums.size() - 1;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) >>> 1;
            if (nums.get(mid) > num) {
                high = mid - 1;
            } else if (nums.get(mid) < num) {
                low = mid + 1;
            } else {
                nums.add(mid, num);
                return;
            }
        }

        if (mid < nums.size() && nums.get(mid) < num) {
            nums.add(mid + 1, num);
        } else {
            nums.add(mid, num);
        }
    }

    /**
     * Function to find the median among all the elements so far, with O(1).
     *
     * @return The median
     */
    public double findMedian() {
        if (nums.isEmpty())
            return 0.0;

        // Odd number of elements
        if (nums.size() % 2 == 1)
            return nums.get(nums.size() / 2);

        // Even number of elements
        int firstNum = nums.get(nums.size() / 2 - 1);
        int secondNum = nums.get(nums.size() / 2);
        return (firstNum + secondNum) / 2.0;
    }
}