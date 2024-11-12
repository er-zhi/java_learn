package problem_solving.Stack;
import java.util.*;

public class MyQueue {

    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        moveFromInToOut();
        return out.pop();
    }

    public int peek() {
        moveFromInToOut();
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void moveFromInToOut() {
        if (out.isEmpty()) {
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
