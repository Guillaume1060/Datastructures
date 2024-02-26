package stack;

public class Stack {

    private Node top;
    private int height;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getTop() {
        System.out.println("Top: " + top.value);
    }

    public void getHeight() {
        System.out.println("Height: " + height);
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop() {
        if (height==0) return null;
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }

    // EXO 38
/*    public void push(T item) {
        stackList.add(item); // It brings it at the queue as expected
        }

    // EXO 39
        public T pop(){
        if (isEmpty()) return null;
        return stackList.remove(size()-1);
    }

    // EXO 40
        public static String reverseString(String str) {
        Stack stack = new Stack();
        String reverseString = "";
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            reverseString += stack.pop();
        }
        return reverseString;
    }

    // EXO 41
        public static boolean isBalancedParentheses(String str){
        Stack<Character> stack = new Stack<Character>();
        for (char c:str.toCharArray()) {
            if (c=='(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // EXO 42
        public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> additionalStack = new Stack<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while(!additionalStack.isEmpty() && additionalStack.peek()>temp) {
                stack.push(additionalStack.pop());
            }
            additionalStack.push(temp);
        }

        while (!additionalStack.isEmpty()) {
            stack.push(additionalStack.pop());
        }
    }


    // EXO 43
        public void enqueue(int value) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(value);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }

*/
}
