package graphs;
import java.util.*;

class Node {
    static final int  WHITE = 0;
    static final int  GRAY = 1;
    static final int  BLACK = 2;
    int data;
    int color;
    Node pi;
    int d;

    public Node(int data) {
        this.data = data;
        color = WHITE;
        pi = null;
        d = Integer.MAX_VALUE;
    }
}

public class BFS {

    // void bfsDriver(ArrayList<ArrayList<Node>> G) {
    //     for (int i = 1; i < G.size(); i++) {
    //         if (G.get(i).get)
    //     }
    // } 

    static void bfs(ArrayList<ArrayList<Node>> G, Node s) {
        s.pi = null;
        s.color = Node.GRAY;
        s.d = 0;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        boolean visited[] = new boolean[G.size()];
        queue.offerLast(s);
        
        while (!queue.isEmpty()) {
            Node u = queue.pollFirst();
            visited[u.data] = true;
            for (int i = 0; i < G.get(u.data).size(); i++) {
                Node v = G.get(u.data).get(i);
                if (visited[v.data] == false) {
                    v.color = Node.GRAY;
                    v.d = u.d + 1;
                    v.pi = u;
                    visited[v.data] = true;
                    queue.offerLast(v);
                }
            }
            u.color = Node.BLACK;
            if (u.color == Node.BLACK)
                System.out.print(u.data + " ");
        }
        
    }

    static void printGraph(ArrayList<ArrayList<Node>> G) {
        for (int i = 1; i < G.size(); i++) {
            for (int j = 0; j < G.get(i).size(); j++)
                System.out.print(G.get(i).get(j).data + " ");
            System.out.println();
        }
    }
    
    static void printQueue(ArrayDeque<Node> queue) {
        for (Node node : queue) System.out.print(node.data + " ");
        System.out.println();
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Is the graph directed?");
        boolean isDirected = sc.nextBoolean();

        System.out.println("Enter V and E: ");
        int V = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<ArrayList<Node>> G = new ArrayList<>(V + 1);
        for (int i = 0; i <= V; i++) {G.add(new ArrayList<Node>());}
        for (int i = 1; i <= E; i++) {
            System.out.print("Enter u(1 to " + V + ") " + " and v(max " + E + ") to make an edge between them: ");
            int u = sc.nextInt();
            int v = sc.nextInt();

            if (isDirected) {
                G.get(u).add(new Node(v));
            } else {
                G.get(u).add(new Node(v));
                G.get(v).add(new Node(u));
            }
        }

        bfs(G, G.get(1).get(0));
        sc.close();
    }
}
