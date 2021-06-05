package dp;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    static Map<String, Integer> map = null;
    static int coinChange(int c[], int m, int v, Map<String,Integer> map) {
        String key = m + ":" + v;
        // System.out.println(key);
        if (map.containsKey(key))   return map.get(key);
        if (v < 0 || m < 0)  return 0;
        if (v == 0) return 1;
        int val = coinChange(c, m, v - c[m], map) + coinChange(c, m-1, v, map);
        map.put(key, val);
        return val;
    }
    
    static int coinChangeUtils(int c[], int m, int v) {
        Map<String, Integer> table = new HashMap<>();
        map = table;
        return coinChange(c, m, v, table);
    }
    public static void main(String[] args) {
        int m = 3;
        int c[] = {1, 2, 3};
        int v = 10000000;
        // System.out.println(coinChangeUtils(c, m - 1, v));
        // System.out.println(map);

        // bottom-up approach
        int dp[] = new int[v+1];
        dp[0] = 1;
        for (int coin : c) {
            for (int i = coin; i <= v; i++)
                dp[i] = dp[i] + dp[i - coin];
        }
        System.out.println(dp[v]);
    }
}
