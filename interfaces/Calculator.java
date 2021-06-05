package interfaces;

interface Calculator {

    // add
    int add(int a, int b);

    // subtract
    int subtract(int a, int b);

    // multiply
    int multiply(int a, int b);

    // divide
    double divide(double a, double b);

    // remainder
    int remainder(int a, int b);

    // isGreater
    default boolean isGreater(int a, int b) {
        int result =  a - b;

        return (result > 0) ? true : false;
    }

    // isSmaller
    default boolean isSmaller(int a, int b) {
        int result = a - b;

        return (result < 0) ? true : false;
    }

    // isEqual
    default boolean isEqual(int a, int b) {
        return (a == b) ? true : false;
    }
}