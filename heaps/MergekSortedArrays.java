package heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergekSortedArrays {

    static ArrayList<Integer> merge(int arr[][], int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, ((a, b) -> {return a[0] - b[0];}));
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{arr[i][0], i, 0});
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        while (!pq.isEmpty()) {
            int val[] = pq.remove();
            list.add(val[0]);
            if (val[2] + 1 < k)
                pq.offer(new int[]{arr[val[1]][val[2]+1], val[1], val[2] + 1});
        }

        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int[][] arr = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++)
                arr[i][j] = sc.nextInt();
        }

        ArrayList<Integer> list = merge(arr, k);
        for (int x : list)   System.out.print(x + " ");
        System.out.println(); 
        sc.close();
    }
}
