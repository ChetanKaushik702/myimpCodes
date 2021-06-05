package cp;

import java.io.*;

public class Codechef {
    static final long MOD = (long)1e9 + 7;

    static long solver(int n) {
        if (n == 0) return 1;
        long val = 1, result = 2;
        while (++val <= n) {
            result = ((result % MOD) * (2 % MOD)) % MOD;
        }
        return result;
    }

    static long binExp(int n) {
        if (n == 0) return 1;
        long base = 2, result = 1;
        while (n > 0) {
            if (n % 2 == 1)
                result = ((result % MOD) * (base % MOD)) % MOD;
            base = ((base % MOD) * (base % MOD)) % MOD;
            n /= 2;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().split(" ");
            int G = Integer.parseInt(s[0]);
            int P = Integer.parseInt(s[1]);
            
            int people[] = new int[10];
            for (int i = 0; i < 10; i++)    people[i] = Integer.parseInt(s[i+2]);
            
            int total_people = 0;
            for (int i = G; i < 10; i++)    total_people += people[i];
            int days = 0, minDays = 0, maxDays = 0;
            if (total_people % P == 0) {
                days = total_people / P + 1; 
                minDays = days;
                if (people[G-1] % P == 0)      days += people[G-1] / P;
                else days += people[G-1] / P + 1;
                maxDays = days;
            } else {
                days = total_people / P + 2; 
                minDays = days;
                total_people = total_people % P + people[G-1];
                if (total_people % P == 0)      days += total_people / P;
                else days += total_people / P + 1;
                maxDays = days;
            }
            System.out.println(minDays + " " + maxDays);
        }
        br.close();
    }
}
