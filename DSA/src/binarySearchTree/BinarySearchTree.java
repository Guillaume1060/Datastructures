package binarySearchTree;

import heap.Heap;

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

    public Node getRoot() {
        return root;
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
        while (temp != null) {
            if (temp.value == value) return true;
            if (value > temp.value) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        return false;
    }

    // RECURSIVE PART
    // 1: Contains
    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) return false;
        if (currentNode.value == value) return true;
        if (value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

    // 2: Insert
    private Node rInsert(Node currentNode, int value) {
        // If the node is null, create a new node with the value
        if (currentNode == null) return new Node(value);

        // If the value is less than current node's value,
        // try to insert it in the left subtree
        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        }
        // If the value is greater than current node's value,
        // try to insert it in the right subtree
        else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        // Return the current node after insertion
        return currentNode;
    }

    public void rInsert(int value) {
        if (root == null) root = new Node(value);
        rInsert(root, value);
    }

    // 3:Delete
    private int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) return null;

        if (currentNode.value > value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if ((currentNode.value < value)) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            // Here 4 situations: Node is leafNode(1), One on right and none on left(2) OR inverse(3) and has node on each side(4-HARD ONE).
            if (currentNode.left == null && currentNode.right == null) { //1
                return null;
            } else if (currentNode.right == null) { //3
                currentNode = currentNode.left;
            } else if (currentNode.left == null) { //2
                currentNode = currentNode.right;
            } else { //4
                int subTreeMin = minValue(currentNode.right); // We get the min value of the subTree on the right (which is the next larger value in the BST)
                currentNode.value = subTreeMin;               // we set the min value to the currentNode
                currentNode.right = deleteNode(currentNode.right,subTreeMin); // Here we delete the identical value
            }
        }
        return currentNode;

    }

    public void deleteNode(int value) {
        deleteNode(root, value);
    }

    // EXO INVERSION TREE
    private Node invertTree(Node node) {
        if (node == null) return null;
        Node temp = node.left;
        node.left = invertTree(node.right);
        node.right = invertTree(temp);

        return node;
    }

    public void invert() {
        root = invertTree(root);
    }
}
