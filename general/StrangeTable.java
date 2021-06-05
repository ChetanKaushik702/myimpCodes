package general;

import java.io.*;

public class StrangeTable {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) 
            {
                String s[] = br.readLine().split(" ");
                long n = Long.parseLong(s[0]);
                long m = Long.parseLong(s[1]);
                long x = Long.parseLong(s[2]);

                long row = x % n;
                long col = x / n;

                if (row == 0)   row = n;
                else    col++;

                System.out.println((row - 1) * m + col);
            }
        } catch(IOException e) 
        {
            e.printStackTrace();
        }
    }
}
