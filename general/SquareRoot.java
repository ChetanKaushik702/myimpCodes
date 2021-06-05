package general;

import java.util.Scanner;

public class SquareRoot {

    static int sqroot(int n) {
        if (n == 0) return 0;
        int beg = 1, end = n;
        while (beg <= end) {
            int mid = (beg + end) / 2;
            int sqr = mid * mid;
            if (sqr == n)   return mid;
            else if (sqr < n)   beg = mid + 1;
            else    end = mid - 1;
        }
        return end;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q-- > 0) {
            int n = sc.nextInt();
            if (n >= 0)
                System.out.println(sqroot(n));
            else
                System.out.println("Number must be >= 0");
        }
        sc.close();
    }
}
