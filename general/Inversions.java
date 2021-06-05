package general;
import java.util.Scanner;

class Inversions 
{
    // merge concept to find the number of inversions
    int inversionsUsingMerge(int arr[], int p, int q, int r)
    {
        int inv = 0;
        int n1 = q - p + 1, n2 = r - q;
        int left[] = new int[n1];
        int right[] = new int[n2];

        for (int i = 0; i < n1; i++)    left[i] = arr[p + i];
        for (int i = 0; i < n2; i++)    right[i] = arr[q + i + 1];

        int i = 0, j = 0, k = p;
        while (i < n1 && j < n2)
        {
            if (left[i] > right[j])
            {
                arr[k] = right[j];
                inv += n1 - i;
                j++;
            }
            else
            {
                arr[k] = left[i];
                i++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }

        return inv;
    }
    
    // mergeSort type procedure for storing inversions
    int getInversions(int arr[],int p,int r)
    {
        int inversions = 0;
        if (p < r)
        {
            int q = (p + r) >> 1;
            inversions += getInversions(arr, p, q);
            inversions += getInversions(arr, q+1, r);
            inversions += inversionsUsingMerge(arr, p, q, r);
            // printArray(arr, p, r);
            // System.out.println("Inversions: " + inversions);
        }
        return inversions;
    }

    void printArray(int arr[], int beg, int end) {
        // System.out.println("beg:" + beg + "\tend:" + end);
        System.out.print("[" + arr[beg]);
        for (int i = beg + 1; i <= end; i++)
            System.out.print("," + arr[i]);
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)     arr[i] = sc.nextInt();
        Inversions object = new Inversions();
        object.printArray(arr, 0, arr.length - 1);
        System.out.println(object.getInversions(arr, 0, arr.length - 1));
        object.printArray(arr, 0, arr.length - 1);

        sc.close();
    }
}