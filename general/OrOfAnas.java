package general;
import java.util.Scanner;

public class OrOfAnas {

    static void computeFreq(int freq[], int x, int ext) {
        int base = 1;
        for (int i = 0; i < 32; i++) {
            if ((x & base) >= 1)
                freq[i] += ext;
            base = base << 1;
        }
    }

    static int calculateAns(int freq[]) {
        int base = 1;
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            if (freq[i] > 0)
                ans += base;
            base = base << 1;
        }

        return ans;
    }
    
    static void printArr(int freq[]) {
        for (int x : freq)  System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                // int q = sc.nextInt();
                
                int arr[] = new int[n];
                int freq[] = new int[32]; // storing the freqency of bits
                
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                    computeFreq(freq, arr[i], 1);
                }
                
                printArr(freq);
                // System.out.println(calculateAns(freq));

                // while (q-- > 0) {
                //     int x = sc.nextInt();
                //     int v = sc.nextInt();

                //     x--;
                //     computeFreq(freq, v, 1);
                //     computeFreq(freq, arr[x], -1);
                //     arr[x] = v;

                //     printArr(freq);
                //     System.out.println(calculateAns(freq));
                // }
            }
        }
    }
}
