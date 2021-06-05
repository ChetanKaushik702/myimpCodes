package arrays;

import java.util.Scanner;

public class MedianOfSortedArrays {
    static public double getMedian(int a[], int b[]) {
        double median = 0;
        int[] x, y;
        if (a.length < b.length)    {x = a; y = b;}
        else    {x = b; y = a;}

        int start = 0, end = x.length;
        // System.out.println("start:" + start + "\tend:" + end);
        int total = x.length + y.length;

        while (start <= end) {
            int pX = (start + end) / 2;
            int pY = (total + 1) / 2 - pX;
            // System.out.println("pX:" + pX + "\tpY:" + pY);
            int maxLeftX = (pX == 0) ? Integer.MIN_VALUE : x[pX - 1];
            int minRightX = (pX == x.length) ? Integer.MAX_VALUE : x[pX];

            int maxLeftY = (pY == 0) ? Integer.MIN_VALUE : y[pY - 1];
            int minRightY = (pY == y.length) ? Integer.MAX_VALUE : y[pY];

            // Found case
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                median = (total % 2 == 0) ? (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0 : Math.max(maxLeftX, maxLeftY);
                break;
            }
            else if (maxLeftX > minRightY) {
                end = pX - 1;
            }
            else {
                start = pX + 1;
            }

        }

        return median;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int m = sc.nextInt();
        int b[] = new int[m];
        for (int i = 0; i < m; i++) b[i] = sc.nextInt();

        System.out.println(getMedian(a, b));
        sc.close();
    }
}
