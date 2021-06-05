package graphs;
import java.util.Scanner;

public class GraphList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Node G[] = new Node[n + 1];
        for (int i = 1; i <= m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            if (G[u] == null) {
                Node node = new Node(v);
                G[u] = node;
            } else {
                Node node = new Node(v);
                node.next = G[u];
                G[u] = node;
            }

            if (G[v] == null) {
                Node node = new Node(u);
                G[v] = node;
            } else {
                Node node = new Node(u);
                node.next = G[v];
                G[v] = node;
            }
        }

        for (int i = 1; i <= n; i++) {
            Node node = G[i];
            System.out.print(i + " ");
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
            System.out.println();
        }

        sc.close();
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
