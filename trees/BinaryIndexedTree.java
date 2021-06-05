package trees;
import java.util.Scanner;

public class BinaryIndexedTree {

    // returns the prefix sum of the array upto index 
    static int getSum(int BITree[], int index) {
        int sum = 0;

        index = index + 1;
        while (index > 0) {
            sum = sum + BITree[index];
            index = index & (index - 1);
        }

        return sum;
    }

    static void update(int BITree[], int val, int index) {
        int n = BITree.length - 1;
        while (index <= n) {
            BITree[index] += val;
            index = index + (index & (-index));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)     arr[i] = sc.nextInt();

        int BITree[] = new int[n + 1];
        for (int i = 1; i <= n; i++)
            update(BITree, arr[i - 1], i);

        /*
        System.out.print("arr: ");
        for (int x : arr)   System.out.print(x + " ");

        System.out.print("\nBITree: ");
        for (int x : BITree)    System.out.print(x + " ");
        */

        int q = sc.nextInt();
        while (q-- > 0) {
            int type = sc.nextInt();
            if (type == 1)  {
                int index = sc.nextInt();
                System.out.println(getSum(BITree, index));
            } else {
                int index = sc.nextInt();
                int value = sc.nextInt();
                update(BITree, value, index);
            }
        }
        sc.close();
    }
}
