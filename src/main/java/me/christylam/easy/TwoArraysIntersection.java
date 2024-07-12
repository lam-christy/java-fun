package me.christylam.easy;

import java.util.ArrayList;

/**
 * <p>
 *     This is an easy question provided by LeetCode:
 *     <a href="https://leetcode.com/problems/intersection-of-two-arrays-ii/description/">Intersection of Two Arrays II</a>
 * </p>
 * <p>
 *     The aim is to find the intersection of 2 arrays, where elements could be repeated.
 * </p>
 *
 * @author Christy Lam
 */
public class TwoArraysIntersection {
    /**
     * Function to find the intersection of 2 arrays.
     *
     * @param nums1 array 1
     * @param nums2 array 2
     * @return The array of the intersection
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        // Brutal force - O(n^2)
        // var intersection = new ArrayList<Integer>();
        // for (int num : nums1) {
        //     for (int i = 0; i < nums2.length; i++) {
        //         if (num == nums2[i]) {
        //             intersection.add(num);
        //             nums2[i] = -1;
        //             break;
        //         }
        //     }
        // }
        // return intersection.stream().mapToInt(i->i).toArray();

        // Sort approach - O(n log n)
        // Arrays.sort(nums1);
        // Arrays.sort(nums2);

        // var intersection = new ArrayList<Integer>();
        // for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
        //     if (nums1[i] == nums2[j]) {
        //         intersection.add(nums1[i]);
        //         i++;
        //         j++;
        //     } else if (nums1[i] > nums2[j]) {
        //         j++;
        //     } else {
        //         i++;
        //     }
        // }
        // return intersection.stream().mapToInt(i->i).toArray();

        // Similar to a counting sort approach with array - O(n) this solution provides the best performance
        int[] nums1Bucket = new int[1001];
        for (int num : nums1) {
            nums1Bucket[num]++;
        }

        var intersection = new ArrayList<Integer>();
        for (int num : nums2) {
            if (nums1Bucket[num] > 0) {
                intersection.add(num);
                nums1Bucket[num]--;
            }
        }
        return intersection.stream().mapToInt(i->i).toArray();

        // Similar to a counting sort approach with Map - O(n)
        // var numsMap = new HashMap<Integer, Integer>();
        // for (int num : nums1) {
        //     numsMap.merge(num, 1, Integer::sum);
        // }

        // var intersection = new ArrayList<Integer>();
        // for (int num : nums2) {
        //     if (numsMap.get(num) != null) {
        //         intersection.add(num);
        //         if (numsMap.get(num) == 1) {
        //             numsMap.remove(num);
        //         } else {
        //             numsMap.put(num, numsMap.get(num) - 1);
        //         }
        //     }
        // }
        // return intersection.stream().mapToInt(i->i).toArray();
    }
}
