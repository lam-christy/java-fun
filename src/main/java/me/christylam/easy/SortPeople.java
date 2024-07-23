package me.christylam.easy;

import java.util.Arrays;
import java.util.Collections;

/**
 * <p>
 *     This is an easy question provided by LeetCode:
 *     <a href="https://leetcode.com/problems/sort-the-people/description/">Sort the People</a>
 * </p>
 * <p>
 *     The aim is to sort the list of people by their height.
 * </p>
 *
 * @author Christy Lam
 */
public class SortPeople {
    /**
     * Function to sort the list of people by their height from tallest to shortest.
     *
     * @param names list of people's names
     * @param heights list of respective people's heights
     * @return The list of people's names sorted by height in descending order
     */
    public String[] sortPeople(String[] names, int[] heights) {
        People[] people = new People[names.length];
        for (int i = 0; i < names.length; i++) {
            people[i] = new People(names[i], heights[i]);
        }

        Arrays.sort(people, Collections.reverseOrder());
        return Arrays.stream(people).map(person -> person.name).toArray(String[]::new);
    }
}

class People implements Comparable<People> {
    final String name;
    private final int height;

    People(String name, int height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public int compareTo(People people) {
        return Integer.compare(this.height, people.height);
    }
}