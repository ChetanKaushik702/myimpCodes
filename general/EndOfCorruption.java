package general;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class EndOfCorruption {

    static int secondMax(ArrayList<Integer> list, int max) {
        int max2 = -2;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == max) continue;
            if (max2 < list.get(i))
                max2 = list.get(i);
        }
        return max2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // ArrayList<Integer> list = new ArrayList<>();

        // int loop = n + m;
        // boolean flag = false;
        // int max = -1, index = -1;
        // while (loop-- > 0) {
        //     int val = sc.nextInt();
        //     if (val != -1) {
        //         if (flag) {
        //             list.set(index, val);
        //             flag = false;
        //         } else {
        //             list.add(val);
        //         }
        //         if (max < val)  {
        //             max = val;
        //             index = list.indexOf(val);
        //         }
        //     } else {
        //         System.out.println(max);
        //         flag = true;
        //         max = secondMax(list, max);
        //     }
        // }
        int loop = n + m;
        TreeSet<Integer> tree = new TreeSet<>();
        while (loop-- > 0) {
            int in = sc.nextInt();
            if (in == -1)   System.out.println(tree.pollLast());
            else    tree.add(in);
        }
        sc.close();
    }
}
