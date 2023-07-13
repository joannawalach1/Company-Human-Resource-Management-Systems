package pl.great.waw.company3.repository.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciCounterTest {
    private List<FibonacciCounter> fibMethods;

    @BeforeEach
    void setup() {
        fibMethods = Arrays.asList(new FibonacciCounterIterative(), new FibonacciCounterRecursion(), new FibonacciStream());
    }

    @Test
    void fibonacciMethods() {
        fibMethods.forEach(fibonacciCounter -> {
            assertEquals(0, fibonacciCounter.findValue(0));
            assertEquals(1, fibonacciCounter.findValue(1));
            assertEquals(55, fibonacciCounter.findValue(10));
        });
    }


    @Test
    void fibonacciPerformance() {
        boolean positive = false;
        for (FibonacciCounter fibonacciCounter : fibMethods) {
            long startTime = System.nanoTime();
            fibonacciCounter.findValue(5);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println(fibonacciCounter + "Czas wykonania metody: " + duration + " μs");
            positive = true;
        }
        assertTrue(positive);
    }
}