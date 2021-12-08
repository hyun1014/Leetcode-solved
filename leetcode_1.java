package com.company;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    class Num implements Comparable<Num> {
        int number;
        int order;

        Num (int number, int order) {
            this.number = number;
            this.order = order;
        }

        @Override
        public int compareTo(Num n) {
            if (this.number == n.number)
                return Integer.compare(this.order, n.order);
            else
                return Integer.compare(this.number, n.number);
        }
    }
    public int[] twoSum(int[] nums, int target) {
        Num[] numArray = new Num[nums.length];
        for (int i = 0; i < nums.length; i++)
            numArray[i] = new Num(nums[i], i);
        Arrays.sort(numArray);

        int front = 0;
        int rear = numArray.length - 1;
        int sum;
        while (front < rear) {
            sum = numArray[front].number + numArray[rear].number;
            if (sum == target)
                break;
            else if (sum > target)
                rear--;
            else
                front++;
        }
        return new int[]{numArray[front].order, numArray[rear].order};
    }
}