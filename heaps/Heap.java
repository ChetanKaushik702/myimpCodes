package heaps;
import java.util.ArrayList;
import java.util.Scanner;

public class Heap {
    ArrayList<Integer> list;
    int heapSize;

    Heap(ArrayList<Integer> list) {
        this.list = list;
        heapSize = list.size();
    }

    // add element
    void add(int val) {
        list.add(val);
        heapSize++;
    }
    
    // parent(i)
    int parent(int index) {return (index - 1) / 2;}

    // left child(i)
    int left(int index) {return 2*index + 1;}

    // right childe(i)
    int right(int index) {return 2*index + 2;}

    // max heap
    void maxHeapify(int i) {
        int leftChild = left(i);
        int rightChild = right(i);
        int largest = i;

        if (leftChild < heapSize && list.get(leftChild) > list.get(i))
            largest = leftChild;
        if (rightChild < heapSize && list.get(rightChild) > list.get(largest))
            largest = rightChild;
        if (largest != i) {
            int temp = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, temp);

            maxHeapify(largest);
        }
    }

    // build heap
    void buildHeap() {
        for (int i = heapSize / 2 - 1; i >= 0; i--)
            maxHeapify(i);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        var list = new ArrayList<Integer>();
        var heap = new Heap(list);

        boolean flag = false;
        int loop = n + m;
        while (loop-- > 0) {
            int in = sc.nextInt();
            if (in == -1) {
                heap.buildHeap();
                System.out.println(heap.list.get(0));
                System.out.println(heap.heapSize + "\t" + list);
                if (flag == false)
                    flag = true;
            }
            else if (flag) {
                heap.list.set(0, in);
                flag = false;
            }else {
                heap.add(in);
            }

        }

        sc.close();
    }
}
