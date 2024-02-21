package LL_INTERVIEW_EXERCISES;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    // EXO 28 - SWAP FIRST & LAST
    public void swapFirstLast() {
        if (length < 2) return;
        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }

    // EXO 29 - REVERSE - My way
/*    public void reverse() {
        if (length<2) return;
        Node temp = head;
        head = tail;
        tail = temp;
        Node after; // = temp.next;
        Node before = null;
        for (int i=0;i<length;i++) {
            // init after
            after = temp.next;

            // reverse
            Node tempNext = temp.next;
            temp.next = before;
            temp.prev = tempNext;

            // update for next
            before = temp;
            temp = after;
        }
    }*/
    // BETTER WAY
    public void reverse() {
        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        temp = head;
        head = tail;
        tail = temp;
    }

    // EXO 30 - IS PALINDROME - Bad way
/*    public boolean isPalindrome() {
        StringBuilder vice = new StringBuilder();
        StringBuilder versa = new StringBuilder();
        Node temp = head;
        Node temp2 = tail;
        for (int i=0;i<length;i++) {
            vice.append(temp.value);
            temp = temp.next;
        }
        for (int i=length;i>0;i--) {
            versa.append(temp2.value);
            temp2 = temp2.prev;
        }
        return vice.toString().equals(versa.toString());
    }*/

    // Better way
    public boolean isPalindrome() {
        if(length<=1) return true;
        Node forwarderNode = head;
        Node backwarderNode = tail;
        for (int i=0;i<length/2;i++) {
            if (forwarderNode.value != backwarderNode.value) return false;
            forwarderNode = forwarderNode.next;
            backwarderNode = backwarderNode.prev;
        }
        return true;
    }
}