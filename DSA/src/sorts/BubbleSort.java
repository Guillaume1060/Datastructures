package sorts;

public class BubbleSort {

    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {    // i * comparison (ex : 5,4,3,2,1)
            for (int j = 0; j < i; j++) {               // We run this i times
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
                // if (minIndex == i) break; // ?? Does it work
            }
            if (i != minIndex) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j>-1 && temp < arr[j]) {
                arr[j+1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }
}
