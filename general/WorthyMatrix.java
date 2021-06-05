package general;

import java.io.*;

public class WorthyMatrix {

    static void solve(double arr[][], int n, int m, int k) {

        int count = 0;

        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= m ; j++) {
                arr[i][j] += arr[i][j-1];
                // System.out.print(arr[i][j] + " ");
            }
            // System.out.println();
        }
        
        for (int i = 1 ; i <= m ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                arr[j][i] += arr[j-1][i];
                // System.out.print(arr[j][i] + " ");
            }
            // System.out.println();
        }

        for (int u = 1 ; u <= Math.min(n, m) ; u++) {

            for (int i = u ; i <= n ; i++) {

                for (int j = u ; j <= m ; j++) {

                    double avg = (arr[i][j] + arr[i-u][j-u] - arr[i-u][j] - arr[i][j-u]) / (u * u);
                    if (avg >= k)   count++;

                }
            } 
        }

        System.out.println(count);
    }
    
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {

                String s[] = br.readLine().split(" ");
                int n = Integer.parseInt(s[0]);
                int m = Integer.parseInt(s[1]);
                int k = Integer.parseInt(s[2]);

                double arr[][] = new double[n + 1][m + 1];

                for (int i = 1 ; i <= n ; i++) {
                    s = br.readLine().split(" ");
                    for (int j = 1 ; j <= m ; j++) {
                        arr[i][j] = Double.parseDouble(s[j - 1]);
                    }
                }

                solve(arr, n, m, k);
            }
        }
    }
}
