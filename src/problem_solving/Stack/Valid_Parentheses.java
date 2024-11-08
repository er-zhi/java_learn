package problem_solving.Stack;

import java.util.*;

public class Valid_Parentheses {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push the corresponding closing bracket
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');

            // If it's a closing bracket
            else {
                // If stack is empty but there is an extra closing bracket
                if (stack.isEmpty()) return false;
                // Brackets don't match the popped element
                if (stack.pop() != c) return false;
            }
        }

        // If stack is empty, all brackets matched; otherwise, return false
        return stack.isEmpty();
    }
}
