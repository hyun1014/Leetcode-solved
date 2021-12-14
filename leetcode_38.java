package com.company;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        int recursiveCount = 1;
        while (recursiveCount < n) {
            char currentNumber = '.';
            int currentIndex = 0;
            while (currentIndex < sb.length()) {
                currentNumber = sb.charAt(currentIndex);
                int count = 1;
                currentIndex++;
                while (currentIndex < sb.length() && sb.charAt(currentIndex) == currentNumber) {
                    currentIndex++;
                    count++;
                }
                String countString = String.valueOf(count);
                sb.replace(currentIndex - count, currentIndex, countString + Character.toString(currentNumber));
                currentIndex = currentIndex - count + countString.length() + 1;
            }

            recursiveCount++;
        }

        return sb.toString();
    }
}
