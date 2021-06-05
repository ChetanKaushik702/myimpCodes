package cp;

import java.io.*;

public class Code {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                int n = Integer.parseInt(br.readLine());
                String input[] = br.readLine().split(" ");
                int s = 0;
                int c1 = 0, c2 = 0, c3 = 0;
                for (int i = 0; i < n; i++) {
                    s = Integer.parseInt(input[i]);
                    if (s == 1)  c1++;
                    else if (s == 2) c2++;
                    else if (s == 3) c3++;
                }
                n = n - Math.min(c1, c3) - c2 / 2;

                c1 = c1 - Math.min(c1, c3);
                c2 = c2 % 2;
                n = n - Math.min(c1, c2);

                c1 = c1 - Math.min(c1, c2);
                if (c1 % 4 == 0) {
                    n = n - c1 + c1 / 4;
                }
                else {
                    n = n - 4 * (c1 / 4) + c1 / 4;
                    c1 = c1 % 4;

                    if (c1 % 3 == 0) {
                        n = n - c1 + c1 / 3;
                    }
                    else {
                        n = n - 3 * (c1 / 3) + c1 / 3;
                        c1 = c1 % 3;

                        if (c1 % 2 == 0) {
                            n = n - c1 + c1 / 2;
                        }
                        else {
                            n = n - 2 * (c1 / 2) + c1 / 2;
                        }
                    }
                }
                System.out.println(n);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
