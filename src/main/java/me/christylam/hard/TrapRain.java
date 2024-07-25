package me.christylam.hard;

import java.util.Stack;

/**
 * <p>
 *     This is a hard question provided by LeetCode:
 *     <a href="https://leetcode.com/problems/trapping-rain-water">Trapping Rain Water</a>
 * </p>
 * <p>
 *     The aim is to find how much water can be trapped after raining, given an array of elevated height across the x-axis, where the width of each index is 1.
 * </p>
 *
 * @author Christy Lam
 */
public class TrapRain {
    /**
     * Function to find the amount of rain water trapped.
     *
     * @param height the array of an elevation map across an x-axis
     * @return The amount of trapped rain water
     */
    public int trap(int[] height) {
        if (height.length == 1) {
            return 0;
        }

        var stack = new Stack<Elevation>();
        int i = 1;
        int ans = 0;

        while (i < height.length) {
            if (height[i - 1] > height[i]) {
                stack.add(new Elevation(height[i - 1], i - 1));
            } else if (height[i - 1] < height[i]) {
                int value = height[i - 1];
                while (!stack.isEmpty()) {
                    if (stack.peek().value <= height[i]) {
                        Elevation elevation = stack.pop();
                        ans += (elevation.value - value) * (i - elevation.index - 1);
                        value = elevation.value;
                    } else {
                        ans += (height[i] - value) * (i - stack.peek().index - 1);
                        break;
                    }
                }
            }
            i++;
        }

        return ans;
    }
}

class Elevation {
    public int value;
    public int index;

    public Elevation(int value, int index) {
        this.value = value;
        this.index = index;
    }
}