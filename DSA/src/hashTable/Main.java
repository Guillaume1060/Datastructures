package hashTable;

import java.util.*;

public class Main {
    // INTERVIEW QUESTION
    // Bad way O(n²)
    public static boolean itemInCommon(int[] arr1, int[]arr2) {
        for (int i:arr1) {
            for (int j:arr2) {
                if (i==j) return true;
            }
        }
        return false;
    }
    // Better way with hashTable O(n)
    public static boolean itemInCommonBetter(int[] arr1, int[]arr2) {
        HashMap<Integer,Boolean> myHashMap = new HashMap<>();
        for (int i:arr1) {
            myHashMap.put(i,true);
        }
        for (int j:arr2) {
            if (myHashMap.get(j) != null) return true;
        }
        return false;
    }

    // EXO 53
    public static ArrayList<Integer> findDuplicates(int[] nums) {
        // Create a new HashMap to store the count of occurrences
        // of each integer.
        Map<Integer, Integer> numCounts = new HashMap<>();
        // Loop through each integer in the input array and update
        // its count in the HashMap.
        for (int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        }
        // Create a new ArrayList to store the duplicate integers.
        ArrayList<Integer> duplicates = new ArrayList<>();
        // Loop through each entry in the HashMap and check if the
        // count of occurrences is greater than 1.
        for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        // Return the ArrayList of duplicate integers.
        return duplicates;
    }

    // EXO 54
    public static Character firstNonRepeatingChar(String str) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (Map.Entry<Character,Integer> c : map.entrySet()) {
            if (c.getValue() == 1) return c.getKey();
        }
        return null;
    }

    // EXO 55
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
            for (int i=0;i<nums.length;i++) {
            int num = nums[i];
            int complement = target - num;
            if(map.containsKey(complement)) {
                return new int[]{map.get(complement),i};

            } else {
                map.put(num, i);
            }
        }
        return new int[]{};


        // BAD HABIT
        // for (int i=0;i<nums.length;i++) {
        //     for (int j=i+1;j<nums.length;j++) {
        //         if (nums[i]+nums[j] == target) {
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return new int[]{};

    }

    // EXO 56
    public static int[] subarraySum(int[] nums, int target) {
        // Create a HashMap to store cumulative sum and index
        Map<Integer, Integer> sumIndex = new HashMap<>();
        // Initialize the HashMap with 0 sum and index -1
        sumIndex.put(0, -1);
        // Initialize the current sum to 0
        int currentSum = 0;

        // Iterate through the input array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the cumulative sum
            currentSum += nums[i];
            // Check if the required subarray sum exists
            int toCheck = currentSum - target;
            if (sumIndex.containsKey(currentSum - target)) {
                // Return the start and end indices of the subarray
                return new int[]{sumIndex.get(currentSum - target) + 1, i};
            }
            // Store the current sum and its index in the HashMap
            sumIndex.put(currentSum, i);
        }

        // Return an empty array if no subarray is found
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 9;
        int[] result1 = subarraySum(nums1, target1);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");

//        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
//        HashTable myHashTable = new HashTable();
//
//        myHashTable.set("nails",100);
//        myHashTable.set("tile",50);
//        myHashTable.set("lumber",80);
//
//        myHashTable.set("bolts",200);
//        myHashTable.set("screws",140);
//
//        System.out.println(myHashTable.get("bolts"));
//        System.out.println(myHashTable.keys());
//
//        myHashTable.printTable();
    }
}
