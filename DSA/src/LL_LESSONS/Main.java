package LL_LESSONS;

public class Main {
    public static void main(String[] args) {
//        LinkedList myLinkedList = new LinkedList(11);
//        myLinkedList.append(3);
//        myLinkedList.append(23);
//        myLinkedList.append(7);

//        myLinkedList.prepend(1);
//        System.out.println(myLinkedList.get(2).value);
//        myLinkedList.printList();
//        myLinkedList.set(1,4);
//        myLinkedList.insert(0,99);
//        myLinkedList.insert(1,98);
//        myLinkedList.printList();
/*        System.out.println(myLinkedList.removeLast().value);
        System.out.println(myLinkedList.removeLast().value);
        System.out.println(myLinkedList.removeLast());*/

        DoublyLinkedList myDLL = new DoublyLinkedList(0);
        myDLL.append(1);
        myDLL.append(2);
        myDLL.append(3);

        myDLL.insert(1,18);

        myDLL.printList();

//        System.out.println(myDLL.get(1).value);
//        System.out.println(myDLL.get(2).value);
//        myDLL.getHead();
//        myDLL.getTail();
//        myDLL.getLength();

//        System.out.println(myDLL.removeLast().value);
//        System.out.println(myDLL.removeLast().value);
//        System.out.println(myDLL.removeLast());


    }
}