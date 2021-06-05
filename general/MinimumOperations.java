package general;
import java.util.Hashtable;

public class MinimumOperations {
    
    public static int minOperation(int N) {
        // return helperRoutine(1, 1, N);
        Hashtable<Integer, Integer> mem = new Hashtable<>();
        return optimisedUsingDP(1, 1, N, mem);
    }

    public static int helperRoutine(int n, int steps, int N) {
        // base case
        if (n > N) return Integer.MAX_VALUE;
        else if (n == N) return steps;

        else return Math.min(helperRoutine(n + 1, steps + 1, N),
                         helperRoutine(n << 1, steps + 1, N));
    }

    /* 
        dp[i] = minimum number of steps to obtain i
        i = 0   -> 0    
        i = 1   -> 1    dp[i - 1] + 1
        i = 2   -> 2    dp[i - 1] + 1
        i = 3   -> 3    dp[i - 1] + 1
        i = 4   -> 
    */
    public static int optimisedUsingDP(int n, int steps, int N, Hashtable<Integer, Integer> mem)
    {
        System.out.println(mem);
        // base case
        if (mem.containsKey(n))    return mem.get(n);
        else if (n > N) 
        {
            mem.put(n, Integer.MAX_VALUE);
            return mem.get(n); // Integer.MAX_VALUE
        }
        else if (n == N)
        {
            mem.put(n, steps);
            return mem.get(n); // steps
        }
        else 
        {
            int val = Math.min(optimisedUsingDP(n + 1, steps + 1, N, mem),
                               optimisedUsingDP(n << 1, steps + 1, N, mem));
            mem.put(n, val);
            return val;
        }   
    }

    static int combinations(int n) {
        if (n < 0)  return 0;
        else if (n == 0)    return 1;
        else    return combinations(n - 3) + combinations(n - 5) +
                combinations(n - 10);
    }

    public static void main(String[] args) {
        // System.out.println(minOperation(4));
        // System.out.println(minOperation(8));
        // System.out.println(minOperation(7));

        System.out.println(combinations(8));
        System.out.println(combinations(13));
        System.out.println(combinations(20));
    }
}
