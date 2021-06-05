package general;

public class Fibonacci {
    
    static long findFib(int n) {
        long fib[] = new long[n + 1];
        
        fib[0] = 0; fib[1] = 1;
        // System.out.print(fib[0] + " " + fib[1] + " ");
        for (int i = 2 ; i <= n ; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            // System.out.print(fib[i] + " ");
        }

        return fib[n];
    }

    public static void main(String[] args) {
        // findFib(10);
        System.out.println(findFib(1000));
    }
}
