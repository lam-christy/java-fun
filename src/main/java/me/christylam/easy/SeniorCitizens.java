package me.christylam.easy;

import java.util.Arrays;

/**
 * <p>
 *     This is an easy question provided by LeetCode:
 *     <a href="https://leetcode.com/problems/number-of-senior-citizens">Number of Senior Citizens</a>
 * </p>
 * <p>
 *     The aim is to find the number of people above the age of 60. Given an array of strings,
 *     where the first 10 characters are phone number; the next character denotes the gender; the next 2 characters are the age and last 2 characters are the seat allocation.
 * </p>
 *
 * @author Christy Lam
 */
public class SeniorCitizens {
    /**
     * Function to find number of senior citizens above the age of 60.
     *
     * @param details the string providing information about the citizen
     * @return the number of senior citizens
     */
    public int countSeniors(String[] details) {
        return (int) Arrays.stream(details).filter(detail -> Integer.parseInt(detail.substring(11, 13)) > 60).count();
    }
}
