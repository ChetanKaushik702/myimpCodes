package trees;
public class STree {

    static void construct(int a[], int st[], int l, int h, int p) {
        if (l == h) {
            st[p] = a[l];
            return; 
        }
        int m = (l + h) / 2;
        construct(a, st, l, m, 2*p + 1);
        construct(a, st, m + 1, h, 2*p + 2);
        st[p] =  st[2*p + 1] | st[2*p + 2];
    } 

    static void update(int st[], int ss, int se, int i, int prev_val, int new_val, int si) {
        st[si] = (st[si] | prev_val) | new_val;
        if (se != ss) {
            int mid = (ss + se) >> 1;
            update(st, ss, mid, i, prev_val, new_val, 2*si + 1);
            update(st, mid+1, se, i, prev_val, new_val, 2*si + 2);
        } 
    }

    public static void main(String[] args) {

        int n = 4;
        int a[] = {1, 2, 3, 4};
        int st[] = new int[4 * n];
        construct(a, st, 0, 3, 0);

        for (int x: st) System.out.print(x + " ");
    }
}
