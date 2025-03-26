public class FibonacciPerformance {
    public static void main(String[] args) {
        int n = 25;

        // Measure Recursive Fibonacci
        long startTime = System.nanoTime();
        int recResult = fibonacciRecursive(n);
        long endTime = System.nanoTime();
        System.out.println("Recursive Fibonacci Result: " + recResult);
        System.out.println("Recursive Time: " + (endTime - startTime) / 1_000_000 + " ms");

        // Measure Iterative Fibonacci
        startTime = System.nanoTime();
        int iterResult = fibonacciIterative(n);
        endTime = System.nanoTime();
        System.out.println("Iterative Fibonacci Result: " + iterResult);
        System.out.println("Iterative Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    // Recursive Fibonacci (Exponential O(2ⁿ))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (Linear O(N))
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}

/*
Recursive Fibonacci Result: 75025
Recursive Time: 2 ms
Iterative Fibonacci Result: 75025
Iterative Time: 0 ms
 */
