package general;
import java.util.*;

public class Kadanes {
    
    int maxSumSubArray(int A[]) {
        int currentMax = A[0], overallMax = A[0];

        for (int i = 1; i < A.length; i++) {
            currentMax = Math.max(A[i], currentMax + A[i]);
            if (overallMax < currentMax)
                overallMax = currentMax;
        }

        return overallMax;
    }

    int maxProductSubArray(int A[]) {
        int currMax = A[0], currMin = A[0], overallMax = A[0];

        for (int i = 1; i < A.length; i++) {
            int temp_currMax = currMax;
            currMax = Math.max(A[i], Math.max(currMin * A[i], currMax * A[i]));
            currMin = Math.min(A[i], Math.min(currMin * A[i], temp_currMax * A[i]));
        
            if (overallMax < currMax)   overallMax = currMax;
        }

        return overallMax;
    }

    int subArrayWithAGivenSum(int A[], int sum) {
        int currSum = 0, freq = 0;
        HashSet<Integer> setOfPrefixSums = new HashSet<Integer>();

        for (int i = 0; i < A.length; i++) {
            currSum = currSum + A[i];
            if (currSum == sum) freq++;
            else if (setOfPrefixSums.contains(currSum - sum))   freq++;
            else    setOfPrefixSums.add(currSum);
        }

        return freq;
    }

    void slidingWindowApproachForSubarray(int arr[], int sum) {
        int currSum = arr[0], beg = 0, end = 1;
        while (end <= arr.length) {
            System.out.println("currSum: " + currSum + "\tbeg: " + beg + "\tend: " + end);
            while (currSum > sum && beg < end) {
                currSum -= arr[beg];
                beg++;
            }

            if (currSum == sum) {
                System.out.println("beg: " + (beg + 1) + "\tend: " + (end));
                break;
            }

            currSum += arr[end];
            end++;
        }
    }

    void sumClosestToANumberK(int arr[], int K) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE, x = -1, y = -1;

        // For consecutive elements
        // for (int i = 1; i < arr.length; i++) {
        //     if (Math.abs(arr[i] + arr[i-1] - K) < min) {
        //         min = Math.abs(arr[i] + arr[i-1]);
        //         x = i - 1;
        //         y = i;
        //     }
        // }

        int beg = 0, end = arr.length - 1;
        while (beg < end) {
            int sum = arr[beg] + arr[end] - K;
            if (Math.abs(sum) < Math.abs(min)) {
                min = sum;
                x = beg;
                y = end;
            }
            if (sum < 0)    beg++;
            else    end--;
        }

        System.out.println("Numbers are: " + arr[x] + " and " + arr[y] + "\nSum: " + min);
    }

    public static void main(String[] args) {
        Kadanes kadanes = new Kadanes();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)     arr[i] = sc.nextInt();
        // System.out.println(kadanes.maxSumSubArray(arr));
        // System.out.println(kadanes.maxProductSubArray(arr));
        // System.out.println(kadanes.subArrayWithAGivenSum(arr, 4));
        int t = sc.nextInt();
        while (t-- > 0)
        // kadanes.slidingWindowApproachForSubarray(arr, sc.nextInt());
        kadanes.sumClosestToANumberK(arr, sc.nextInt());
        Set<Integer> set = new HashSet<>();
        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        sc.close();
    }
}
