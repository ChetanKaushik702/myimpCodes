package cp;

import java.io.*;

public class KMP {

    void constructLPS(int lps[], String s) {
        int i = 1, len = 0;
        lps[len] = 0;
        char ch[] = s.toCharArray();
        while (i < ch.length) {
            if (ch[i] == ch[len]) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if (len != 0)
                    len = lps[len - 1];
                else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    boolean isSubstr(String txt, String pat) {
        int lps[] = new int[txt.length()];
        constructLPS(lps, pat);
        int i = 0, j = 0;
        while (i < txt.length()) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == pat.length())
                return true;
            else if (i < txt.length() && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0)
                    j = lps[j - 1];
                else    
                    i++;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 24; i++) {
            String s[] = br.readLine().split(" ");
            String pat = s[1];
            String txt = s[0];

        }
    }
}
