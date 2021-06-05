package inheritance;

class A {
    int i, j;

    A(int i, int j) {
        this.i = i;
        this.j = j;
    }

    void show() {
        System.out.println("i and j are: " + i + " " + j);
    }
}

class B extends A {
    int k;

    B(int i, int j, int k) {
        super(i, j);
        this.k = k;
    }

    @Override
    void show() {
        System.out.println("k is:" + k);
    }
}

public class SuperDemo {
    public static void main(String[] args) {
        A superOb = new B(1, 2, 3);
        B subOb = new B(1, 2, 3);

        superOb.show();
        subOb.show();
    }
}