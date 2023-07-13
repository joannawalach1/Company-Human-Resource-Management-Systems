package pl.great.waw.company3.repository.fibonacci;

public class FibonacciCounterRecursion implements FibonacciCounter {
    @Override
    public int findValue(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else {
            return findValue(n - 1) + findValue(n - 2);
        }
    }
}
