package trees;
public class FenwickTree {
    int fenw[];
    int arr[];

    FenwickTree(int nums[]) {
        arr = nums;
        fenw = new int[nums.length + 1];
    }

    int getSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum = sum + fenw[x];
            x = x - (x & (-x));
        }
        return sum;
    }

    void update(int index, int delta) {
        while (index <= arr.length) {
            fenw[index] += delta;
            index = index + (index & (-index));
        }
    }

    void buildTree() {
        for (int i = 1; i <= arr.length; i++) {
            update(i, arr[i - 1]);
        }
    }
    
    public static void main(String[] args) {
        int n = 8;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i + 1;
        
        FenwickTree fenwickTree = new FenwickTree(arr);
        fenwickTree.buildTree();

        for (int x : fenwickTree.arr)  System.out.print(x + " ");
        System.out.println();
        for (int x : fenwickTree.fenw)  System.out.print(x + " ");
    }
}
