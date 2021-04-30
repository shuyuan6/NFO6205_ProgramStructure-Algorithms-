package finalExam;

public class FibonacciNumbers {
    // n is the input number
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int fib(int n) {
        if (n == 1) {
            return 1;
        }

        int first = 0;
        int second = 1;

        int res = 0;
        for (int i = 2; i < n + 1; i++) {
            res = first + second;
            first = second;
            second = res;
        }

        return res;
    }

    public static void main(String[] args) {
        FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
        int input = 4;
        System.out.println("Result should be 3: " + fibonacciNumbers.fib(input));
    }
}
