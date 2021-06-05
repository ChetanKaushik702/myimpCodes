package cp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String s = sc.nextLine();
        char[] str1 = new char[n];
        char[] str2 = new char[n];
        s.getChars(0, n, str1, 0);
        s.getChars(n, 2*n, str2, 0);

        int q = sc.nextInt();
        while (q-- > 0) {
            int t = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (t == 1) {
                if (a >= 1 && a <= n) {
                    if (b >= 1 && b <= n) {
                        char temp = str1[a-1];
                        str1[a-1] = str1[b-1];
                        str1[b-1] = temp;
                    } else {
                        b = b - n;
                        char temp = str1[a-1];
                        str1[a-1] = str2[b-1];
                        str2[b-1] = temp;
                    }
                } else {
                    a = a - n;
                    b = b - n;
                    char temp = str2[a-1];
                    str2[a-1] = str2[b-1];
                    str2[b-1] = temp;
                }
            } else {
                char[] temp = str1;
                str1 = str2;
                str2 = temp;
            }
        }
        System.out.println(new String(str1) + new String(str2));
        sc.close();
    }
}
