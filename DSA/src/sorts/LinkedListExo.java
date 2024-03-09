package sorts;

public class LinkedListExo {

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

    public LinkedListExo(int value) {
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

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    //EXO 89
    // WRITE BUBBLESORT METHOD HERE //
    public void bubbleSort() {
        if (length < 2) return;
        Node sortedUntil = null;
        while (sortedUntil != head.next) {
            Node currentNode = head;
            while (currentNode.next != sortedUntil) {
                Node nextNode = currentNode.next;
                if (currentNode.value > nextNode.value) {
                    int temp = currentNode.value;
                    currentNode.value = nextNode.value;
                    nextNode.value = temp;
                }
                currentNode = currentNode.next;
            }
            sortedUntil = currentNode;
        }
    }

    //EXO 90
    public void selectionSort() {
        if (length < 2) return;
        Node current = head;
        while (current.next != null) {
            Node minVal = current;
            Node innerCurrent = current.next;
            while (innerCurrent != null) {
                minVal = innerCurrent.value < minVal.value ? innerCurrent : minVal;
                innerCurrent = innerCurrent.next;
            }
            if (current != minVal) {
                int temp = current.value;
                current.value = minVal.value;
                minVal.value = temp;
            }
            current = current.next;

        }
        tail = current;
    }

    //EXO 91
    public void insertionSort() {
        if (length < 2) return;
        Node sortedListHead = head;
        Node unsortedListHead = head.next;
        sortedListHead.next = null;

        while (unsortedListHead != null) {
            Node current = unsortedListHead;
            unsortedListHead = unsortedListHead.next;
            if (current.value<sortedListHead.value) {
                current.next = sortedListHead;
                sortedListHead = current;
            } else {
                Node searchPointer = sortedListHead;
                while (searchPointer.next!=null && current.value>searchPointer.next.value) {
                    searchPointer = searchPointer.next;
                }
                current.next = searchPointer.next;
                searchPointer.next = current;
            }
        }
        head = sortedListHead;
    }

}
