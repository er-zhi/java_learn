package data_structures;

public class Stack_m {
    public static void main(String[] args) {
        // Create a stack of integers
        Stack_l<Integer> intStack = new Stack_l<>();

        // Push elements onto the stack
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);

        // Peek at the top element
        System.out.println("Top element (peek): " + intStack.peek());

        // Pop elements from the stack
        System.out.println("Popped element: " + intStack.pop());
        System.out.println("Popped element: " + intStack.pop());

        // Check the size of the stack
        System.out.println("Current stack size: " + intStack.size());

        // Check if the stack is empty
        System.out.println("Is the stack empty? " + intStack.isEmpty());

        // Push another element
        intStack.push(40);

        // Iterate through the stack
        System.out.println("Stack elements:");
        for (int element : intStack) {
            System.out.println(element);
        }
    }
}

