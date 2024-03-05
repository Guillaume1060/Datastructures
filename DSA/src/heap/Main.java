package heap;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // EXO 72
    // MY VERSION
/*    public static int findKthSmallest(int[] nums,int k) {
        Heap myHeap = new Heap();
        for (int num : nums) {
            myHeap.insert(num);
        }
        int toRemove = myHeap.getHeap().size() - k;
        for (int i=0;i<toRemove;i++) {
            myHeap.remove();
        }
        return myHeap.getHeap().get(0);
    }*/
    // CORRECTION
/*    public static int findKthSmallestCorrection(int[] nums, int k) {
        Heap maxHeap = new Heap();

        for (int num : nums) {
            maxHeap.insert(num);
            if (maxHeap.getHeap().size() > k) {
                maxHeap.remove();
            }
        }

        return maxHeap.remove();
    }*/

    // EXO 73
    public static List<Integer> streamMax(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Heap myHeap = new Heap();
        for (int num : nums) {
            myHeap.insert(num);
            int maxNum = myHeap.getHeap().get(0);
            result.add(maxNum);
        }
        return result;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 5, 2, 9, 3, 6, 8};
        System.out.println("Test case 1:");
        System.out.println("Input: [1, 5, 2, 9, 3, 6, 8]");
        System.out.println("Expected output: [1, 5, 5, 9, 9, 9, 9]");
        System.out.println("Actual output: " + streamMax(nums1));
        System.out.println();
    }
}
