package heaps;

import java.util.Scanner;

class Node {
    private int key;
    private int data;
    
    Node(int key, int data) {
        this.key = key;
        this.data = data;
    }

    public int getKey() {return key;}

    public void setKey(int newKey) {key = newKey;}

    public int getValue() {return data;}

    public void setValue(int newValue) {data = newValue;}
}

/**
 * Implementing the max-priority queue using heap(max-heap)
 */
public class PriorityQueue {
    Node[] pq;
    int limit;

    PriorityQueue(int n) {
        pq = new Node[n + 1];
        limit = n;
    }
    
    // build max heap
    void buildMaxHeap() {
        for (int i = 2; i < pq.length - limit; i++) {
            if (pq[i].getKey() > pq[i-1].getKey()) {
                int j = i;
                while (j > 1 && pq[j].getKey() > pq[(j/2)].getKey()) {
                    Node temp = pq[j];
                    pq[j] = pq[j/2];
                    pq[j/2] = temp;
                    j = j / 2;
                }
            }
        }
    }

    // get element with highest priority
    Node getMaxPriorityNode() {
        if (limit == pq.length - 1) return null;
        else   return pq[1];
    }

    // insert (key, data)
    void insert(int key, int data) {
        if (limit <= 0) System.out.println("Priority Queue is full");
        else {
            Node node = new Node(key, data);
            pq[pq.length - limit] = node;
            limit -= 1;
            buildMaxHeap();
        }
    }

    void printStatus() {
        System.out.println("Current status:");
        for (int i = 1; i < pq.length; i++) {
            if (pq[i] != null) {
                System.out.println(i + ": " + pq[i].getKey() + "\t" + pq[i].getValue());
            }
        }
    }

    // driver method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue priorityQueue = new PriorityQueue(n);

        for (int i = 1; i <= n; i++) {
            int key = sc.nextInt();
            int data = sc.nextInt();
            priorityQueue.insert(key, data);
            // priorityQueue.printStatus();
            Node maxPNode = priorityQueue.getMaxPriorityNode();
            System.out.println(maxPNode.getKey() + "\t" + maxPNode.getValue());
        }

        sc.close();
    }
}