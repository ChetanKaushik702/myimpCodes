package general;
import java.util.Scanner;

class RodCuttingDP {

    // top-down dp approach
    static int rodCut(int p[], int n) {
        int r[] = new int[n + 1];
        for (int i = 0 ; i <= n ; i++)   r[i] = Integer.MIN_VALUE;
        return rodCutAux(p, n, r);
    }

    static int rodCutAux(int p[], int n, int r[]) {
        if (r[n] >= 0)  return r[n];
        int q = Integer.MIN_VALUE;

        if (n == 0) q = 0;

        for (int i = 1 ; i <= n ; i++) {
            q = Math.max(q, p[i - 1] + rodCutAux(p, n - i, r));
        }
        r[n] = q;
        return q;
    }

    // bottom-up approach
    static int bottomUpRodCut(int []p, int n) {
        int r[] = new int[n + 1];
        for (int i = 0 ; i <= n ; i++)  r[i] = 0;

        for (int i = 1 ; i <= n ; i++) {
            int q = Integer.MIN_VALUE;
            for (int j = 1 ; j <= i ; j++)
                q = Math.max(q, p[j - 1] + r[i - j]);
            r[i] = q;
        }
        return r[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p[] = new int[n];

        for (int i = 0 ; i < n ; i++) p[i] = sc.nextInt();

        System.out.println(rodCut(p, n));
        System.out.println(bottomUpRodCut(p, n));
        sc.close();
    }
}