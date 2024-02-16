package LL_INTERVIEW_EXERCISES;

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
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
        // create a loop by connecting the tail to the second node
        myLinkedList.getTail().next = myLinkedList.getHead().next;
        System.out.println("Has Loop:");
        System.out.println( myLinkedList.hasLoop());
        /*
            EXPECTED OUTPUT:
            ----------------
            Has Loop:
            true
        */
    }
}
