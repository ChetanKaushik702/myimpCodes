package interfaces;

class MyCalculator implements Calculator {

    // private int op1, op2;

    // public MyCalculator(int op1, int op2) {
    //     this.op1 = op1;
    //     this.op2 = op2;
    // }

    @Override
    public int add(int a, int b) {
        int result = a + b;
        return result;
    }

    @Override
    public int subtract(int a, int b) {
        int result = a - b;
        return result;
    }

    @Override
    public int multiply(int a, int b) {
        int result = a * b;
        return result;
    }

    @Override
    public double divide(double a, double b) {
        double result = a * b;
        return result;
    }

    @Override
    public int remainder(int a, int b) {
        int result = a % b;

        if (result < 0)     result += b;
        return result;
    }

    public static void main(String[] args) {
        var clc = new MyCalculator();
        System.out.println("ADD(-2, 10): " + clc.add(-2, 10));
        System.out.println("REMAINDER(-2, 10): " + clc.remainder(-2, 10));
    }
    
}