package array_LEETCODE_exercises;

import java.util.Arrays;

public class Array {

    // EXO 101 -MAX PROFIT
    public static int maxProfit(int[] prices) {
        // Initialize minPrice with the highest possible integer value.
        int minPrice = Integer.MAX_VALUE;
        // Initialize maxProfit with 0, assuming no profit at the beginning.
        int maxProfit = 0;
        // Loop through each price in the array.
        for (int price : prices) {
            // If current price is lower than minPrice, update minPrice.
            minPrice = Math.min(minPrice, price);
            // Calculate potential profit for current price.
            int profit = price - minPrice;
            // If current profit is more than maxProfit, update maxProfit.
            maxProfit = Math.max(maxProfit, profit);
        }
        // After checking all prices, return the maximum profit.
        return maxProfit;
    }

    // EXO 102
    public static void rotate(int[] nums, int k) {
        // Reduce k to its equivalent value within array length range.
        k = k % nums.length;

        // Reverse the first part of the array (from start to length-k)
        for (int start = 0, end = nums.length - k - 1; start < end; start++, end--) {
            // Swap elements at positions 'start' and 'end'
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }

        // Reverse the second part of the array (from length-k to end)
        for (int start = nums.length - k, end = nums.length - 1; start < end; start++, end--) {
            // Swap elements at positions 'start' and 'end'
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }

        // Reverse the whole array
        for (int start = 0, end = nums.length - 1; start < end; start++, end--) {
            // Swap elements at positions 'start' and 'end'
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }

    // EXO 103
    public static int maxSubarray(int[] nums) {
        if (nums.length==0) return 0;
        int cumul = nums[0];
        int max = nums[0];

        for (int i=1;i<nums.length;i++) {
            cumul += nums[i];
            cumul = Math.max(cumul, nums[i]);
            max = Math.max(cumul,max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        rotate(nums1, k1);
        System.out.println("Test case 1: Rotated array: " + Arrays.toString(nums1));
        // prints "Rotated array: [5, 6, 7, 1, 2, 3, 4]"
    }
}
