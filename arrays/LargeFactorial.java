package arrays;

import java.util.Scanner;

public class LargeFactorial {
    static final int MAX = (int)1e6 + 7;

    String factorial(int n) {
        int[] fact = new int[MAX];
        fact[1] = 1;
        int size = 1;

        for (int i = 2; i <= n; i++) {
            size = computeFact(fact, size, i);
        }
        StringBuilder fact_ans = new StringBuilder();
        for (int i = size; i >= 1; i--)
            fact_ans.append(Integer.toString(fact[i]));
        return fact_ans.toString();
    }

    int computeFact(int fact[], int size, int dig) {
        int carry = 0;
        for (int pos = 1; pos <= size; pos++) {
            int prod = fact[pos] * dig + carry;
            fact[pos] = prod % 10;
            carry = prod / 10;
        }

        while (carry != 0) {
            size++;
            fact[size] = carry % 10;
            carry /= 10;
        }

        return size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of times you want to compute factorial of a number:");
        int q = sc.nextInt();
        LargeFactorial factorial = new LargeFactorial();
        while (q-- > 0) {
            System.out.println("Enter the number:");
            int n = sc.nextInt();
            String fact = factorial.factorial(n);
            System.out.println(fact);
        }
        sc.close();
    }
}
