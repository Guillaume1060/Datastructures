package sorts;
import java.util.Arrays;
import static sorts.BubbleSort.*;

public class Main {
    public static void main(String[] args) {
        int[] myArray = {4,2,6,5,1,3};

        //bubbleSort(myArray);
        //selectionSort(myArray);
        //insertionSort(myArray);


        //System.out.println( Arrays.toString(myArray) );

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6]

         */

        LinkedListExo myLinkedList = new LinkedListExo(4);
        myLinkedList.append(2);
        myLinkedList.append(6);
        myLinkedList.append(5);
        myLinkedList.append(1);
        myLinkedList.append(3);



        System.out.println("Unsorted Linked List:");
        System.out.println("Head = "+myLinkedList.getHead().value);
        myLinkedList.printList();

        myLinkedList.bubbleSort();

        System.out.println("\nSorted Linked List:");
        myLinkedList.printList();



        /*
            EXPECTED OUTPUT:
            ----------------
            Unsorted Linked List:
            4
            2
            6
            5
            1
            3

            Sorted Linked List:
            1
            2
            3
            4
            5
            6

        */
    }
}
