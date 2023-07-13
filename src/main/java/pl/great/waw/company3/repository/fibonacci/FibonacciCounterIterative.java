package pl.great.waw.company3.repository.fibonacci;

public class FibonacciCounterIterative implements FibonacciCounter {

    @Override
    public int findValue(int n) {
        int first = 0;
        int second = 1;
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else if (n > 1) {
            for (int i = 1; i <= n; i++) {
                int result = first + second;
                first = second;
                second = result;
            }
        }
        return first;
    }
}