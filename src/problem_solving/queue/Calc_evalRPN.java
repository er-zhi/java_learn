package problem_solving.queue;
import java.util.*;
//https://leetcode.com/problems/evaluate-reverse-polish-notation/

public class Calc_evalRPN {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int x = stack.pop();
                int y = stack.pop();
                int result = calc(y, x, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public int calc(int x, int y, String operator) {
        return switch (operator) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> x / y;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }
}

