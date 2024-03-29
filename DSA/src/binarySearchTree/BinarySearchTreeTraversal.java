package binarySearchTree;

import java.util.*;


public class BinarySearchTreeTraversal {

    public Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

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
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    // 1.Breadth-first search traversal
    public ArrayList<Integer> BSF() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(currentNode);

        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            result.add(currentNode.value);
            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }
        return result;
    }

    // 2.a.Depth First Search - PRE-ORDER
    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        // Inner class to create method inside a method
        class Traverse {
            Traverse(Node currentNode) {
                results.add(currentNode.value);
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return results;
    }

    //An alternative way of solving this with a recursive helper method:
    public ArrayList<Integer> DFSPreOrderBis() {
        ArrayList<Integer> results = new ArrayList<>();
        DFSPreOrderHelper(root, results);
        return results;
    }
    private void DFSPreOrderHelper(Node currentNode, ArrayList<Integer> results) {
        if (currentNode == null) return;

        results.add(currentNode.value);
        DFSPreOrderHelper(currentNode.left, results);
        DFSPreOrderHelper(currentNode.right, results);
    }

    // 2.b.Depth First Search - POST-ORDER
    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) new Traverse(currentNode.left);
                if (currentNode.right != null) new Traverse(currentNode.right);
                results.add(currentNode.value);
            }
        }
        new Traverse(root);
        return results;
    }

    // 2.c.Depth First Search - IN-ORDER
    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) new Traverse(currentNode.left);
                results.add(currentNode.value);
                if (currentNode.right != null) new Traverse(currentNode.right);
            }
        }
        new Traverse(root);
        return results;
    }

    // EXO 84
    public boolean isValidBST() {
        ArrayList<Integer> BSTInOrder = DFSInOrder();
        int temp = BSTInOrder.get(0);
        for (int i = 1; i < BSTInOrder.size(); i++) {
            if (temp > BSTInOrder.get(i)) return false;
            temp = BSTInOrder.get(i);
        }
        return true;
    }

    // Correction ->
    public boolean isValidBSTCorrection() {
        ArrayList<Integer> nodeValues = DFSInOrder();
        for (int i = 1; i < nodeValues.size(); i++) {
            if (nodeValues.get(i) <= nodeValues.get(i - 1)) return false;
        }
        return true;
    }

    // EXO 85
    public Integer kthSmallest(int k) {
        Stack<Node> stack = new Stack<>();

        if (root == null) return null;
        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) new Traverse(currentNode.left);
                stack.add(currentNode);
                if (currentNode.right != null) new Traverse(currentNode.right);
            }
        }
        new Traverse(root);
        List<Node> copyStack = new ArrayList<>(stack);
        for (Node node : copyStack) {
            if (k == 1) return node.value;
            stack.pop();
            k--;
        }
        return null;
    }
    // Correction
    public Integer kthSmallestCorrection(int k) {
        Stack<Node> stack = new Stack<>();
        Node node = this.root;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            k -= 1;
            if (k == 0) {
                return node.value;
            }
            node = node.right;
        }
        return null;
    }
}
