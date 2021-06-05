package general;

public class Hanoi {
     
    static void toh(int n, int from, int to, int aux) {
         if (n == 1) {
            System.out.println("move disk 1 from tower " + from + " to tower " + to);
            return;
         }
         toh(n-1, from, aux, to);
         System.out.println("move disk " + n + " from tower " + from + " to tower " + to);
         toh(n-1, aux, to, from);
     }

     public static void main(String[] args) {
         toh(3, 1, 3, 2);
         System.out.println();
         toh(4, 1, 3, 2);
     }
}
