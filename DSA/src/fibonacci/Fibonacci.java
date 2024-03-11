package fibonacci;

public class Fibonacci {
    static int counter = 0;

    // INEFFICIENT WAY
    /*public static int fib(int n) {
        counter++;
        if (n == 0 || n == 1) return n;
        return fib(n - 1) + fib(n - 2);
    }*/

    // WITH MEMOIZATION
    static Integer[] memo = new Integer[100];
    public static int fib(int n) {
        counter++;
        if (memo[n] !=null) return memo[n];
        if (n == 0 || n == 1) return n;
        memo[n] = fib(n - 1) + fib(n - 2);
        return memo[n];
    }

    // BOTTOM UP
    public static int fibBottomUp(int n) {
        int[] fibList = new int[n+1];
        fibList[0] = 0;
        fibList[1] = 1;
        for (int i=2;i<=n;i++) {
            fibList[i] = fibList[i-1] + fibList[i-2];
        }
        return fibList[n];
    }

    public static void main(String[] args) {
        int n = 20;
        System.out.println("Fib of " + n + " = " + fibBottomUp(n));
        System.out.println("Counter= " + counter);
    }
}