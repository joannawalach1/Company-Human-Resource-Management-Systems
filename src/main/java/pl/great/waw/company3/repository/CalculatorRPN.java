package pl.great.waw.company3.repository;

import java.util.Stack;

//TODO not works - to be fixed in future
public class CalculatorRPN {

    public String[] splitEquation(String equation) {
        String[] splitEquation = equation.split(" ");
        return splitEquation;
    }

    public Stack<String>[] createStocks(String[] splitEquation) {
        Stack<String> operatorStack = new Stack<>();
        Stack<String> operandStack = new Stack<>();

        for (String token : splitEquation) {
            if (isOperand(token)) {
                operandStack.push(token);
            } else if (isOperator(token)) {
                operatorStack.push(token);
            }
        }
        Stack<String>[] stacks = new Stack[]{operandStack, operatorStack};
        return stacks;
    }

    public static String createRPN(String[] tokens) {
        StringBuilder rpnBuilder = new StringBuilder();
        Stack<String> operatorStack = new Stack<>();
        Stack<String> operandStack = new Stack<>();

        for (String token : tokens) {
            if (isOperand(token)) {
                operandStack.push(token);
            } else if (isOperator(token)) {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(token)) {
                    operandStack.push(operatorStack.pop());
                }
                operatorStack.push(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    operandStack.push(operatorStack.pop());
                }
                if (!operatorStack.isEmpty() && operatorStack.peek().equals("(")) {
                    operatorStack.pop();
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            operandStack.push(operatorStack.pop());
        }

        while (!operandStack.isEmpty()) {
            rpnBuilder.append(operandStack.pop()).append(" ");
        }

        return String.valueOf(rpnBuilder.reverse());
    }

    public static double calculate(String rpnExpression) {
        String[] tokens = rpnExpression.split(" ");
        Stack<Double> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperand(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = performOperation(token, operand1, operand2);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private static double performOperation(String operator, double operand1, double operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            case "^":
                return Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException("Nieznany operator: " + operator);
        }
    }

    private static boolean isOperand(String element) {
        return element.matches("\\d+");
    }

    private static boolean isOperator(String element) {
        return element.matches("[(-+*/^)]");
    }

    private static int precedence(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            case "^" -> 3;
            case "(", ")" -> 4;
            default -> 0;
        };
    }
}