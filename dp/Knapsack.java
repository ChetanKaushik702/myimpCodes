package dp;
import java.util.*;

public class Knapsack {
    
    // brute force
    int knapsack(int val[], int wt[], int n, int W) {
        if (W <= 0 || n <= 0)  return 0;
        if (wt[n-1] > W)    return knapsack(val, wt, n-1, W);
        return Math.max(knapsack(val, wt, n-1, W - wt[n-1]) + val[n-1],
               knapsack(val, wt, n-1, W));
    }

    // top-down
    int kH(int val[], int wt[], int n, int W) {
        Map<String, Integer> map = new HashMap<>();
        return kT(val, wt, n, W, map);
    }

    int kT(int val[], int wt[], int n, int W, Map<String, Integer> map) {
        String key = n + ":" + W;
        if (map.containsKey(key))   return map.get(key);
        if (n <= 0 || W <= 0) {
            map.put(key, 0);
            return 0;
        }
        if (wt[n-1] > W)    return kT(val, wt, n-1, W, map);
        int value = Math.max(kT(val, wt, n-1, W, map), kT(val, wt, n-1, W-wt[n-1], map) + val[n-1]);
        map.put(key, value);
        return value;
    }

    // bottom-up
    int kB(int val[], int wt[], int n, int W) {
        int dp[][] = new int[n+1][W+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (j < wt[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]] + val[i-1]);
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int wt[] = {1, 2, 3};
        int val[] = {10, 15, 40};
        int W = 6;
        System.out.println(new Knapsack().knapsack(val, wt, 3, W));
        System.out.println(new Knapsack().kH(val, wt, 3, W));
        System.out.println(new Knapsack().kB(val, wt, 3, W));
    }

}
