public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(11);
        myLinkedList.append(3);
        myLinkedList.append(23);
        myLinkedList.append(7);

//        myLinkedList.prepend(1);
//        System.out.println(myLinkedList.get(2).value);
//        myLinkedList.printList();
        myLinkedList.set(1,4);
        myLinkedList.insert(0,99);
        myLinkedList.insert(1,98);
        myLinkedList.printList();
/*        System.out.println(myLinkedList.removeLast().value);
        System.out.println(myLinkedList.removeLast().value);
        System.out.println(myLinkedList.removeLast());*/

    }
}