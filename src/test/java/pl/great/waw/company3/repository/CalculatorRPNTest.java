package pl.great.waw.company3.repository;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorRPNTest {
    CalculatorRPN calculator = new CalculatorRPN();

    @Test
    public void splitEquationTest() {
        String[] arrayOfEquations = calculator.splitEquation("3 + 4 * 2 / (1 - 5) ^ 2 ^ 3");
        assertEquals(13, Arrays.stream(arrayOfEquations).count());
    }

    @Test
    public void createStocks() {
        String[] splitEquation = {"3", "+", "4", "*", "2", "/", "(", "1", "-", "5", ")", "^", "2", "^", "3"};
        Stack<String>[] op = calculator.createStocks(splitEquation);
        assertEquals(op[0].peek(), "3");
        assertEquals(op[1].peek(), "^");
        assertEquals(op.length, 2);
    }

    @Test
    public void createRPN() {
        String[] tokens = {"3", "+", "4", "*", "2", "/", "(", "1", "-", "5", ")", "^", "2", "^", "3"};
        String rpnExpression = calculator.createRPN(tokens);

    }
}