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
    public static List<List<String>> groupAnagrams(String[] strings) {
        // Create a map to store anagram groups
        Map<String, List<String>> anagramGroups = new HashMap<>();

        // Iterate over each string in the input array
        for (String string : strings) {
            // Convert the string to a char array
            char[] chars = string.toCharArray();
            // Sort the char array
            Arrays.sort(chars);
            // Create a canonical string from sorted chars
            String canonical = new String(chars);

            // Check if the map contains the canonical key
            if (anagramGroups.containsKey(canonical)) {
                // Add the string to the existing group
                anagramGroups.get(canonical).add(string);
            } else {
                // Create a new group for the string
                List<String> group = new ArrayList<>();
                group.add(string);
                // Add the new group to the map
                anagramGroups.put(canonical, group);
            }
        }

        // Return the groups as a new ArrayList
        return new ArrayList<>(anagramGroups.values());
    }

    // EXO 56
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

    // EXO 57
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

    // EXO 58
    public static List<Integer> removeDuplicates(List<Integer> myList) {
        Set<Integer> mySet = new HashSet<>(myList);
        return new ArrayList<>(mySet);
    }

    // EXO 59
    public static boolean hasUniqueChars(String string) {
        Set<Character> charSet = new HashSet<>();
        for (char ch : string.toCharArray()) {
            if (charSet.contains(ch)) {
                return false;
            }
            charSet.add(ch);
        }
        return true;
    }

    // EXO 60
    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        Set<Integer> mySet = new HashSet<>();
        List<int[]> pairs = new ArrayList<>();

        for (int num : arr1) {
            mySet.add(num);
        }
        for (int num : arr2) {
            int complement = target - num;
            if (mySet.contains(complement)) {
                pairs.add(new int[]{complement,num});
            }
        }
        return pairs;
    }

    // EXO 61
    public static int longestConsecutiveSequence(int[] nums){
        Set <Integer> mySet = new HashSet<>();
        int longestStreak = 0;

        for (int num : nums) {
            mySet.add(num);
        }

        for (int num : mySet) {
            if (!mySet.contains(num-1)) {
                int currentNumber = num;
                int currentStreak = 1;
                while (mySet.contains(currentNumber+1)) {
                    currentStreak++;
                    currentNumber++;
                }
                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
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
