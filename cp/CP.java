package cp;

import java.util.*;
import java.io.*;

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastReader(String fileName) throws Exception {
        br = new BufferedReader(new FileReader(fileName));
    }

    String next() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch(IOException e) {
                throw new Exception(e.toString());
            }
        }
        return st.nextToken();
    }

    String nextLine() throws Exception {
        String str = "";
        try {
            str = br.readLine();
        } catch(IOException e) {
            throw new Exception(e.toString());
        }
        return str;
    }
}

public class CP {
    static boolean multipleTC = true;
    FastReader in;
    PrintWriter out;

    int bit(long n){return (n == 0) ? 0 : 1 + bit(n & (n-1));}

    int ni() throws Exception{return Integer.parseInt(in.next());}
    long nl() throws Exception{return Long.parseLong(in.next());}
    double nd() throws Exception{return Double.parseDouble(in.next());}
    
    String n() throws Exception{return in.next();}
    String nln() throws Exception{return in.nextLine();}

    void p(Object o){out.print(o);}
    void pn(Object o){out.println(o);}
    void pni(Object o){out.println(o);out.flush();}

    // for pre-processing
    void pre() throws Exception{}

    // solve method
    void solve(int TC) throws Exception{
        while (TC > 0) {
            int N = ni();
            int A[] = new int[N];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                A[i] = ni();
                if (min > A[i]) min = A[i];
            }

            int ans = 0;
            for (int x : A) if (x == min)   ans++;
            pni(N - ans);
            TC--;
        }
    }

    void run() throws Exception {
        in = new FastReader();
        out = new PrintWriter(System.out);

        int TC = multipleTC ? ni() : 1;
        pre();
        solve(TC);
        out.flush();
        out.close();
    }

    public static void main(String[] args) throws Exception{
        CP cp = new CP();
        cp.run();
    }

}