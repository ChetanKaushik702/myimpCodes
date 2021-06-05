package general;

import java.util.*;

public class TernarySearch {

    static boolean ternarySearch(int arr[], int key) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid1 = l + (r-l) / 3;
            int mid2 = r - (r-l) / 3;

            if (key == arr[mid1])  {
                System.out.println(mid1);
                return true;
            }
            if (key == arr[mid2])  {
                System.out.println(mid2);
                return true;
            }

            if (key < arr[mid1]) r = mid1 - 1;
            else if (key > arr[mid2])   l = mid2 + 1;
            else {
                l = mid1 + 1;
                r = mid2 - 1;
            }
        }

        System.out.println("Not found");
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int q = sc.nextInt();
        while (q-- > 0) {
            ternarySearch(arr, sc.nextInt());
        }
        
        sc.close();
    }
}
