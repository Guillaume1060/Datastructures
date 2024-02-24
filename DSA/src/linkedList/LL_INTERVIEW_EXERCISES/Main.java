package linkedList.LL_INTERVIEW_EXERCISES;

public class Main {
    public static void main(String[] args) {
        // EXO 12
/*        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
        System.out.println("1 -> 2 -> 3 -> 4 -> 5");
        System.out.println( "Middle Node: "+ myLinkedList.findMiddleNode().value);
        myLinkedList.append(6);
        System.out.println("===========================");
        System.out.println("1 -> 2 -> 3 -> 4 -> 5 -> 6");
        System.out.println( "Middle Node: "+ myLinkedList.findMiddleNode().value);*/

        // EXO 13
        /*LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
        // create a loop by connecting the tail to the second node
        myLinkedList.getTail().next = myLinkedList.getHead().next;
        System.out.println("Has Loop:");
        System.out.println( myLinkedList.hasLoop());*/
        /*
            EXPECTED OUTPUT:
            ----------------
            Has Loop:
            true
        */

        // EXO 14
        /*LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        int k = 2;
        int result = myLinkedList.findKthFromEnd(k).value;

        System.out.println(result); // Output: 4*/

        /*
            EXPECTED OUTPUT:
            ----------------
            4

        */

        // EXO 15
        // Create a new LinkedList and append values to it
//        LinkedList ll = new LinkedList(3);
//        ll.append(5);
//        ll.append(8);
//        ll.append(10);
//        ll.append(2);
//        ll.append(1);
//
//        // Print the list before partitioning
//        System.out.println("LL before partitionList:");
//        ll.printList(); // Output: 3 5 8 10 2 1
//
//        // Call the partitionList method with x = 5
//        ll.partitionList(5);
//
//        // Print the list after partitioning
//        System.out.println("LL after partitionList:");
//        ll.printList(); // Output: 3 2 1 5 8 10


        DoublyLinkedList test = new DoublyLinkedList(1);
        test.append(2);
        test.append(3);
        test.append(4);
//        System.out.println(test.isPalindrome());
        test.printList();
        test.swapPairs();
        System.out.println("----------");
        test.printList();

    }
}

