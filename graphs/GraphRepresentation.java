package graphs;
import java.util.Scanner;

public class GraphRepresentation {

    static void printGraph(int G[][]) {
        System.out.println("Adjacency matrix:");
        for (int i = 1; i < G.length; i++) {
            for (int j = 1; j < G[i].length; j++) {
                System.out.print(G[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static void printList(Node G[]) {
        System.out.println("Adjacency list:");
        for (int i = 1; i < G.length; i++) {
            System.out.print(i + " -> ");
            Node node = G[i];
            while (node != null) {
                System.out.print(node.data + " -> ");
                node = node.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // m - number of edges, n - denotes the number of vertices
        System.out.println("Enter nodes and edges: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        // adjacent-matrix representation
        int G[][] = new int[n + 1][n + 1];

        // adjacency-list representation
        Node GList[] = new Node[n + 1];

        for (int i = 0; i < m; i++) {
            System.out.println("Enter nodes u and v to make an edge between them: ");
            // reading the edges between node u and v
            int u = sc.nextInt();
            int v = sc.nextInt();

            // marking the edge between u and v
            G[u][v] = 1;
            G[v][u] = 1;

            // making edge between nodes u and v
            if (GList[u] == null) {
                Node node = new Node(v);
                GList[u] = node;

                if (GList[v] == null) {
                    node = new Node(u);
                    GList[v] = node;
                } else {
                    node.next = GList[u];
                    GList[v] = node;
                }
            } else {
                Node node = new Node(v);
                node.next = GList[u];
                GList[u] = node;

                if (GList[v] == null) {
                    node = new Node(u);
                    GList[v] = node;
                } else {
                    node.next = GList[u];
                    GList[v] = node;
                }
            }
        }

        printGraph(G);
        // printList(GList);
        for (Node node : GList)    System.out.println(node);
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
