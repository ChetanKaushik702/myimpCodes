package lamdas;

// create a functional interface
interface FuncInterface {
    boolean func(int n);
} 
public class ExpressionLamdas {
    
    public static void main(String[] args) {
        // checks whether n is even or odd
        FuncInterface funcInterface = (n) -> ((n & 1) == 0);
        System.out.println(funcInterface.func(4));
        System.out.println(funcInterface.func(5));

        // checks if a number is non-negative or not
        funcInterface = (n) -> (n >= 0);
        System.out.println(funcInterface.func(-1));
        System.out.println(funcInterface.func(4));
    }
}
