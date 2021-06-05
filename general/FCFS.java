package general;
import java.util.*;

public class FCFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of processes: ");
        int n = sc.nextInt();

        int arrivalTime[] = new int[n];
        int burstTime[] = new int[n];

        System.out.println("Enter arrival and burst times of " + n + " processes, respectively");
        for (int i = 0; i < n; i++) {
            arrivalTime[i] = sc.nextInt();
            burstTime[i] = sc.nextInt();
        }

        Hashtable<Integer, Integer> processQueue = new Hashtable<>();
        for (int i = 1; i <= n; i++) {
            processQueue.put(arrivalTime[i - 1], i);
        }
        // System.out.println(processQueue);

        List<Integer> listOfArrivalTime = Collections.list(processQueue.keys());
        Collections.sort(listOfArrivalTime);
        // System.out.println(listOfArrivalTime);

        int completionTime[] = new int[n];
        int countTime = 0;
        for (int i = 0; i < listOfArrivalTime.size(); i++) {
            int id = processQueue.get(listOfArrivalTime.get(i));
            completionTime[id - 1] = countTime + burstTime[id - 1];
            countTime += burstTime[id - 1];
        }
        
        // System.out.print("Completion time: ");
        // displayList(completionTime);
        // System.out.println();

        int TATime[] = new int[n];
        for (int i = 0; i < n; i++) {
            TATime[i] = completionTime[i] - arrivalTime[i];
        }

        // System.out.print("TurnAround time: ");
        // displayList(TATime);
        // System.out.println();

        int waitTime[] = new int[n];
        for (int i = 0; i < n; i++) {
            waitTime[i] = TATime[i] - burstTime[i];
        }

        // System.out.print("Wait time: ");
        // displayList(waitTime);
        // System.out.println();


        System.out.println("Process id\tBurst Time\tArrival Time\tCompletion Time\tTurn around time\tWait time");
        for (int i = 0; i < n; i++) {
            System.out.printf("%9d\t%9d\t%9d\t%9d\t%12d\t%12d\n", i + 1, burstTime[i], arrivalTime[i], completionTime[i], TATime[i], waitTime[i]);
        }

        int averageWaitTime = 0;
        for (int i = 0; i < n; i++) averageWaitTime += waitTime[i];
        System.out.println("\nAverage waiting time: " + ((double)averageWaitTime / n));
        sc.close();
    }

    static void displayList(int list[]) {
        for (int i = 0; i < list.length; i++) System.out.print(list[i] + " ");
    }
}
