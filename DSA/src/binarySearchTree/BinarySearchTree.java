package binarySearchTree;

public class BinarySearchTree {
    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode == temp) return false;
            if (newNode.value > temp.value) {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                } else {
                    temp = root.right;
                }
            } else {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                } else {
                    temp = root.left;
                }
            }
        }
    }

    public boolean contains(int value) {
        // if (root == null) return false; // unuseful
        Node temp = root;
        while (temp!=null) {
            if (temp.value==value) return true;
            if (value> temp.value) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        return false;
    }
}
