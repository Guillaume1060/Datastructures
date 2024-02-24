package stack;

public class Main {
    public static void main(String[] args) {
        Stack myStack = new Stack(4);
        myStack.push(7);
        myStack.push(7);
        myStack.pop();

        myStack.getTop();
        myStack.getHeight();


        myStack.printStack();
    }
}
