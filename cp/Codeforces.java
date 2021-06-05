package cp;

import java.io.*;
import java.util.*;

public class Codeforces {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine());
                String s[] = br.readLine().split(" ");
                int A[] = new int[n];
                int count = 0;
                for (int i = 0; i < n; i++) {
                    A[i] = Integer.parseInt(s[i]);
                    if (A[i] <= 0)  count++;
                }
                Arrays.sort(A);
                int i = 1;
                int min = Integer.MAX_VALUE;
                while (i < n && A[i] <= 0)   {
                    min = Math.min(min, Math.abs(A[i] - A[i-1]));
                    i++;
                }

                while (i < n) {
                    min = Math.min(min, Math.abs(A[i] - A[i-1]));
                    if (min >= A[i])    count++;
                    else    break;
                    i++;
                }
                if (count == 0) count = 1;
                System.out.println(count);
            }
        }
    }
}
