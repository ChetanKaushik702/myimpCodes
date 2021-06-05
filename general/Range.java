package general;

import java.util.Scanner;

public class Range {
    
    static int firstOccuranceInASortedArray(int A[], int val) {

        int beg = 0, end = A.length - 1, result = -1;

        while (beg <= end) {
            int mid = (beg + end) >> 1;
            if (A[mid] < val)   beg = mid + 1;
            else{
                if (A[mid] == val) result = mid;
                end = mid - 1;
            }
        }
        
        return result; 
        
    }

    static int lastOccuranceInASortedArray(int A[], int val) {

        int beg = 0, end = A.length - 1, result = -1;

        while (beg <= end) {
            int mid = (beg + end) >> 1;

            if (A[mid] > val)   end = mid - 1;
            else {
                if (A[mid] == val)  result = mid;
                beg = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int A[] = new int[n];
            for (int i = 0; i < A.length; i++)  A[i] = sc.nextInt();
            int t = sc.nextInt();
            while (t-- > 0) {
                int val = sc.nextInt();
                System.out.println("First: " + firstOccuranceInASortedArray(A, val));
                System.out.println("Last: " + lastOccuranceInASortedArray(A, val));
            }
        } 
    }
}
