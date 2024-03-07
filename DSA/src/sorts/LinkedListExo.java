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
    public  void bubbleSort() {
        if (length < 2) return;
        Node sortedUntil = null;
        while (sortedUntil != head.next) {
            Node currentNode = head;
            while (currentNode.next!=sortedUntil) {
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

}
