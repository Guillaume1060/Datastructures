package mergeSort;

import linkedList.LL_LESSONS.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) return arr;

        int minIndex = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, minIndex));
        int[] right = mergeSort(Arrays.copyOfRange(arr, minIndex, arr.length));

        return merge(left,right);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] combined = new int[arr1.length + arr2.length];
        int index = 0;
        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr1.length) {
            if (arr1[i] < arr2[j]) {
                combined[index] = arr1[i];
                i++;
            } else {
                combined[index] = arr2[j];
                j++;
            }
            index++;
        }
        while (i < arr1.length) {
            combined[index] = arr1[i];
            index++;
            i++;
        }
        while (j < arr2.length) {
            combined[index] = arr2[j];
            index++;
            j++;

        }

        return combined;

    }

    public static void main(String[] args) {

        int[] array1 = {1, 3, 7, 8};
        int[] array2 = {2, 4, 5, 6};

        System.out.println(Arrays.toString(merge(array1, array2)));

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6, 7, 8]

         */

    }
}
