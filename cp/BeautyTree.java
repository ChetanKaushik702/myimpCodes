package cp;

import java.util.*;
import static java.lang.Math.max;
import static java.lang.Math.abs;

public class BeautyTree {
    int A[][];
    int dp[][];
    ArrayList<ArrayList<Integer>> G;
    
    void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                A = new int[2][n+1];
                for (int i = 1; i <= n; i++) {
                    A[0][i] = sc.nextInt();
                    A[1][i] = sc.nextInt();
                }

                G = new ArrayList<ArrayList<Integer>>();
                for (int i = 0; i <= n; i++) {
                    G.add(new ArrayList<Integer>());
                }

                for (int i = 1; i < n; i++) {
                    int u = sc.nextInt();
                    int v = sc.nextInt();
                    G.get(u).add(v);
                    G.get(v).add(u);
                }

                dp = new int[2][n+1];
                dfs(1, -1);
                System.out.println(max(dp[0][1], dp[1][1]));
            }
        }
    }

    void dfs(int u, int p) {
        dp[0][u] = dp[1][u] = 0;
        for (int v : G.get(u)) {
            if (v == p) continue;
            dfs(v, u);
            dp[0][u] += max(dp[0][v] + abs(A[0][u] - A[0][v]), dp[1][v] + abs(A[0][u] - A[1][v]));
            dp[1][u] += max(dp[0][v] + abs(A[1][u] - A[0][v]), dp[1][v] + abs(A[1][u] - A[1][v]));
        }
    }
    public static void main(String[] args) {
        new BeautyTree().solve();
    }
}
