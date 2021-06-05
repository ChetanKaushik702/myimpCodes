package dp;

public class LongestIncreasingSub {
    
    static int longestIncreasingSubsequence(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 2, 5, 3, 7};
        System.out.println(longestIncreasingSubsequence(arr));
    }
}
