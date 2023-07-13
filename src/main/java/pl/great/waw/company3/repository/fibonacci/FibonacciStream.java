package pl.great.waw.company3.repository.fibonacci;

import java.util.stream.Stream;

public class FibonacciStream implements FibonacciCounter {
    public int findValue(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
                    .limit(n + 1)
                    .mapToInt(fib -> fib[0])
                    .reduce((first, second) -> second)
                    .orElse(0);
        }
    }
}
