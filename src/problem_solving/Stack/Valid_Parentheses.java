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
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketMap = new HashMap<>();

        // Map closing brackets to their corresponding opening brackets
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');

        for (char c : s.toCharArray()) {
            if (bracketMap.containsValue(c)) {
                // If it's an opening bracket, push it onto the stack
                stack.push(c);
            } else if (bracketMap.containsKey(c)) {
                // If stack is empty but there is an extra closing bracket
                if (stack.isEmpty()) return false;
                // Brackets don't match the popped element
                if (stack.pop() != bracketMap.get(c)) return false;
            } else {
                // Invalid character encountered
                return false;
            }
        }

        // If the stack is empty, all brackets matched correctly
        return stack.isEmpty();
    }

    public boolean isValid3(String s) {
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();

        boolean isValid = s.chars()
                .mapToObj(c -> (char) c)
                .allMatch(c -> {
                    if (bracketMap.containsValue(c)) {
                        // Opening bracket
                        stack.push(c);
                        return true;
                    } else if (bracketMap.containsKey(c)) {
                        // Closing bracket
                        return !stack.isEmpty() && stack.pop().equals(bracketMap.get(c));
                    } else {
                        // Invalid character
                        return false;
                    }
                });

        return isValid && stack.isEmpty();
    }
}
