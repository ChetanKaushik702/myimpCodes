package general;

import java.io.*;
import java.util.ArrayList;


public class PartialImplementation {
    
    static int solve(StringBuilder s, int k) {
        int replaced = 0;
        boolean isFirstOccurance = false;

        for (int i = 0 ; i < s.length() ; i++)
        {   
            // check for the occurrance of '*'
            if (s.charAt(i) == '*')
            {
                if (!isFirstOccurance)  
                {
                    isFirstOccurance = true;
                    s.setCharAt(i, 'x');
                    replaced++;
                }
            
                // find the position j such that s[j] = '*' and j - i <= k
                int j = i + 1;
                ArrayList<Integer> pos = new ArrayList<Integer>();

                while (j < s.length())
                {
                    if (s.charAt(j) == '*')
                    {
                        if (j - i <= k) 
                        {
                            pos.add(j);
                        }
                    }

                    if (j - i > k)  break;
                    j++;
                }

                if (pos.size() > 0)
                {
                    i = i + pos.get(pos.size() - 1) - 2;
                    s.setCharAt(pos.get(pos.size() - 1), 'x');
                    replaced++;
                }

                if (j == s.length())    break;
            }
        }

        // last character check
        isFirstOccurance = false;
        for (int i = s.length() - 1 ; i >= 0 ; i--)
        {
            if (s.charAt(i) == 'x')     break;
            if (s.charAt(i) == '*')
            {
                s.setCharAt(i, 'x');
                replaced++;
                break;
            }
        }
        System.out.println(s);
        return replaced;
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {
                String[] input = br.readLine().split(" ");
                int k = Integer.parseInt(input[1]);

                StringBuilder s = new StringBuilder(br.readLine());

                System.out.println(solve(s, k));
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
