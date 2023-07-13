package pl.great.waw.company3.helpers;

import java.util.Stack;

public class RPN {

    private RPN() {}

    public static Integer calculate(String expression) {
        String[] tokens = expression.split(" ");
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(a + b);
                }
                case "-" -> {
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(b - a);
                }
                case "*" -> {
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(b * a);
                }
                case "/" -> {
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(b / a);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}


