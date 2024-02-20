package LL_INTERVIEW_EXERCISES;

import java.util.HashSet;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
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
        if (head == null) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("\nLinked List:");
        if (head == null) {
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
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    //EXO12 WRITE FIND MIDDLE NODE METHOD HERE //
    public Node findMiddleNode() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //EXO13 WRITE HASLOOP METHOD HERE
    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //EXO14 - Find Kth Node From End (WITHOUT USING LENGTH)
    // It works but nop optimal (best solution below)
/*    public Node findKthFromEnd(int k) {
        Node temp = head;
        Node temp2 = head;
        int length = 1;
        while (temp!=null && temp.next!=null) {
            length++;
            temp = temp.next;
        }
        if (k>length) return null;
        int position = length-k;
        for (int i=1;i<=position;i++) {
            assert temp2 != null;
            temp2 = temp2.next;
        }
        return temp2;
    }*/
    //EXO14 - Better way
    public Node findKthFromEnd(int k) {
        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    // EXO 15
    public void partitionList(int x) {
        if (head == null) return;
        Node temp = head;
        Node bigHead = null;
        Node bigTail = null;
        Node smallHead = null;
        Node smallTail = null;
        while (temp!=null) {
            Node nextNode = temp.next;
            if (temp.value<x) {
                if(smallHead==null) {
                    smallHead = temp;
                    smallTail = temp;
                } else {
                    smallTail.next = temp;
                    smallTail = temp;
                }
            } else {
                if (bigHead==null) {
                    bigHead = temp;
                    bigTail = temp;
                } else {
                    bigTail.next = temp;
                    bigTail = temp;
                }
            }
            temp.next = null;
            temp = nextNode;
        }
        if (smallHead==null){
            head = bigHead;
        } else {
            head = smallHead;
            smallTail.next = bigHead;
        }
    }

    // EXO 16 WITH HASHSET
    public void removeDuplicates() {
        // Your implementation goes here
        HashSet<Integer> values = new HashSet<Integer>();
        Node previous = null;
        Node current = head;

        while (current!=null) {
            if (values.contains(current.value)) {
                previous.next = current.next;
                length--;
            } else {
                values.add(current.value);
                previous = current;
            }
            current = current.next;
        }
    }

    // EXO 16 WITHOUT HASHSET
    public void removeDuplicatesBis() {
        // Your implementation goes here
        Node current = head;
        while (current!=null) {
            Node runner = current;
            while (runner.next!=null) {
                if (runner.value == runner.next.value) {
                    runner.next = runner.next.next;
                    length--;
                } else {
                    runner = runner.next;
                }
            }
                current = current.next;
            }
        }

        // EXO 17 BinaryToDecimal
        public int binaryToDecimal() {
            int num = 0;
            Node current = head;
            while (current != null) {
                num = num * 2 + current.value;
                current = current.next;
            }
            return num;
        }
}

